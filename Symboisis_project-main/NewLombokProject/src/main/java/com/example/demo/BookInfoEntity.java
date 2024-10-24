package com.example.demo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@Entity
@Table(name = "book_info")
public class BookInfoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_Id")
	private Long bookID;

	@NonNull
	@Column(name = "book_Title")
	private String bookTitle;

	@Column(name = "book_author")
	private String autherName;

	@NonNull
	@Column(name = "book_price")
	private Double sellingPrice;

	@Column(name = "book_catagory")
	private String bookCatagory;

	@Column(name = "book_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
	private LocalDateTime bookTime;

}
