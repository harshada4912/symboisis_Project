//package com.example.demo;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestControllerAdvice
//@RequestMapping()
//public class FileUploadController {
//
//	@PostMapping("uploadAny")
//	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
//		
//		if (file.isEmpty()) {
//			return ResponseEntity.badRequest().body("No file selected for upload.");
//		}
//
//	
//		String originalFilename = file.getOriginalFilename();
//		Path filePath = Paths.get("E:\\Notapad\\uploads", originalFilename);
//
//	
//		Files.createDirectories(filePath.getParent());
//
//		
//		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//		
//		return ResponseEntity.ok("File uploaded successfully: " + originalFilename);
//	}
//}
