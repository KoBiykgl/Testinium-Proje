package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.demo.dto.request.AddBookRequest;
import com.example.demo.dto.request.UpdateBookRequest;
import com.example.demo.dto.response.AddBookResponse;
import com.example.demo.dto.response.BookResponse;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@RestController
@RequestScope
@RequestMapping("/book")
public class BookController {
	
	
	private BookService bookService;

	
	
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}


	@GetMapping("/bookId")
	public BookResponse getBookById(@RequestParam Long bookId) {
		return bookService.findById(bookId);
	}
	
	@GetMapping("/{categoryId}")
	public List<BookResponse> getAllBookCategoryId(Long categoryId){
		
		return bookService.getAllBookCategoryId(categoryId);
	}
	 
	@GetMapping("/{bookStoreId}")
	public List<BookResponse> getAllBookBookStoreId(Long bookStoreId){
		
		return bookService.getAllBookByBookStoreId(bookStoreId);
	}
	
	@GetMapping
	public List<BookResponse> findAll(){
		return bookService.findAll();
	}
	
	@PostMapping
	public AddBookResponse addBook(
		@RequestBody  AddBookRequest request) {
		return bookService.createBook(request);
	}
	
	
	
	@PutMapping("/{bookId}")
	public Book updateOneBook(@PathVariable Long bookId, @RequestBody UpdateBookRequest updateBookRequest) {
		return bookService.updateOneBookById(bookId,updateBookRequest);
	}
	
	
	@DeleteMapping("/{id}")
	public BookResponse deleteBookById(
	  @PathVariable  Long id) {
		 return bookService.removeById(id); 
	} 
	
	
	@DeleteMapping("/{bookId}/{bookStoreId}")
	public Book removeTheBookFromTheBookStore(
			@PathVariable("bookId") Long bookId,
			@PathVariable("bookStoreId") Long bookStoreId) {
		return bookService.removeTheBookFromTheBookStore(bookId,bookStoreId);
	}
	 
	

}
