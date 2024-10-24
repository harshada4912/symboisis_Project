package com.example.demo;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class BookControler {

	@Autowired
	private BookInfoRepo bookInfoRepo;

//	@Autowired
//	private BookInfoService bookInfoService;

	@PostMapping("/uploadFile")
	@ResponseBody
	public String uploadFile(@RequestParam("pdfFile") MultipartFile pdfFile,
			@RequestParam("imageFile") MultipartFile imageFile) throws IOException {

		// Validate file types (optional)
		if (!pdfFile.getContentType().equals("application/pdf") || !imageFile.getContentType().startsWith("image/")) {
			throw new RuntimeException("Invalid file type");
		}

		// Store files in a specific directory
		String uploadDir = "E:\\Notapad\\uploads";
		Path pdfFilePath = Paths.get(uploadDir, pdfFile.getOriginalFilename());
		Path imageFilePath = Paths.get(uploadDir, imageFile.getOriginalFilename());

		Files.copy(pdfFile.getInputStream(), pdfFilePath, StandardCopyOption.REPLACE_EXISTING);
		Files.copy(imageFile.getInputStream(), imageFilePath, StandardCopyOption.REPLACE_EXISTING);

		return "Upload successful!";
	}
 
	
	@PostMapping("uploadAny")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		
		if (file.isEmpty()) {
			return ResponseEntity.badRequest().body("No file selected for upload.");
		}

	
		String originalFilename = file.getOriginalFilename();
		Path filePath = Paths.get("E:\\Notapad\\uploads", originalFilename);

	
		Files.createDirectories(filePath.getParent());

		
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

		
		return ResponseEntity.ok("File uploaded successfully: " + originalFilename);
	}
	
	@PostMapping("/upload3")
    public String uploadFile3(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("-----------1----------");
        File destFile = new File(
                "E:\\Notapad\\uploads" + file.getOriginalFilename());

        System.out.println("dest file path" + destFile.getAbsolutePath());
        file.transferTo(destFile);
        System.out.println("-----------2----------");
        return "File uploaded successfully!";
    }
	
	@PostMapping("/insert")
	public ResponseEntity<BookInfoEntity> insertBook(@RequestBody BookInfoEntity bookInfoEntity) {
		bookInfoRepo.save(bookInfoEntity);
		// System.out.println(bookInfoRepo.save(bookInfoEntity));
		return ResponseEntity.ok(bookInfoEntity);
	}

	@GetMapping("test/{bookTitle}")
	public String findBynamed(@PathVariable String bookTitle) {
		System.out.println(bookInfoRepo.findByBookTitle("koln") + " ......... " + bookTitle);
		return "from test ";
	}

	@RequestMapping("/show1")
	public String show1() {

		return "show1";
	}

	@RequestMapping("/insert1")
	public String show2(BookInfoEntity bookInfoEntity) {
		bookInfoRepo.save(bookInfoEntity);

		return "show1";
	}

	@GetMapping("/jspShowAll")
	public String jspShowAll() {

		return "";
	}

	@GetMapping("/showAll")
	public List<BookInfoEntity> showAll() {
//		System.out.print(bookInfoRepo.findAll());
		return bookInfoRepo.findAll();
	}

	@GetMapping("getById/{bookID}")
	public Optional<BookInfoEntity> getById(@PathVariable Long bookID) throws Exception {
		if (!(bookInfoRepo.existsById(bookID)))
			throw new CustomException("This is a custom exception!handled by piyush😁😁😁 .........");

		return bookInfoRepo.findById(bookID);

	}

	@GetMapping("findByBookName/{bookTitle}")
	public ResponseEntity<List<BookInfoEntity>> getbooksByBookName(@PathVariable String bookTitle) {
		return new ResponseEntity<List<BookInfoEntity>>(bookInfoRepo.findByBookTitle(bookTitle), HttpStatus.OK);
	}

	@GetMapping("findByAutherName/{autherName}")
	public ResponseEntity<List<BookInfoEntity>> getbooksAutherName(@PathVariable String autherName) {
		return new ResponseEntity<List<BookInfoEntity>>(bookInfoRepo.findByAutherName(autherName), HttpStatus.OK);
	}

	@GetMapping("findByBookCatagory/{bookCatagory}")
	public ResponseEntity<List<BookInfoEntity>> getByBookCatagory(@PathVariable String bookCatagory) {
		return new ResponseEntity<List<BookInfoEntity>>(bookInfoRepo.findByBookCatagory(bookCatagory), HttpStatus.OK);
	}

	@GetMapping("canBuyBook/{bookID}")
	public Boolean canBuyBook(@PathVariable Long bookID, BookInfoEntity bookInfoEntity) throws Exception {

		if (!(bookInfoRepo.existsById(bookID)))
			throw new CustomException("This is a custom exception! handled by Piyush ");

		if (bookInfoEntity.getSellingPrice() != null) {
			Boolean canBuy = true;
			if (bookInfoEntity.getSellingPrice() > 500) {
				canBuy = false;
			}
			if (bookInfoEntity.getSellingPrice() < 100) {
				canBuy = false;
			}

			System.out.println(" can  user buy :- " + canBuy);
			return canBuy;
		} else {
			System.out.println(" Book price can not be Null " + bookInfoEntity.getSellingPrice());
			return false;
		}

	}
}
