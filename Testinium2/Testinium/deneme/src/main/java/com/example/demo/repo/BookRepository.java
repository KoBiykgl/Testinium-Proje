package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
	List<Book> findAllBookByCategoryId(Long categoryId);
	
	List<Book> findAllBookByBookStoreId(Long bookStoreId);
	
	Book deleteByIdAndBookStoreId(Long bookId,Long bookStoreId); 
}
