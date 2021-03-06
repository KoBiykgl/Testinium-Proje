package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.request.AddBookRequest;
import com.example.demo.dto.request.UpdateBookRequest;
import com.example.demo.dto.response.AddBookResponse;
import com.example.demo.dto.response.BookResponse;
import com.example.demo.entity.Book;

public interface BookService {

	public BookResponse findById(Long id);

	public List<BookResponse> findAll();

	public AddBookResponse createBook(AddBookRequest request);

	public Book updateOneBookById(Long bookId, UpdateBookRequest updateBookRequest);

	public BookResponse removeById(Long id);

	public List<BookResponse> getAllBookCategoryId(Long categoryId);

	public List<BookResponse> getAllBookByBookStoreId(Long bookStoreId);
	
	Book removeTheBookFromTheBookStore(Long bookId,Long bookStoreId);

}
