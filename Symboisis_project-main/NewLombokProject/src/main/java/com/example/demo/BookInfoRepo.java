package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookInfoRepo extends JpaRepository<BookInfoEntity, Long>{
     List<BookInfoEntity> findByBookTitle(String bookTitle);
     List<BookInfoEntity> findByAutherName(String autherName);
     List<BookInfoEntity> findByBookCatagory(String bookCatagory);
}
