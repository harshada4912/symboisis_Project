package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookInfoService {
	private List<BookInfoEntity> BookData = new ArrayList<>();

	public ResponseEntity<List<BookInfoEntity>> searchBook(String bookTitle) {

		if (bookTitle != null && !bookTitle.isEmpty()) {
			BookData = BookData.stream()
					.filter(user -> user.getBookTitle().toLowerCase().contains(bookTitle.toLowerCase()))
					.collect(Collectors.toList());
		}
		return ResponseEntity.ok(BookData);
	}
}
