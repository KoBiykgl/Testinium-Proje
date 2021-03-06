package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.request.BookStoreRequest;
import com.example.demo.dto.response.BookStoreResponse;

public interface BookStoreService {
	public List<BookStoreResponse> findAll();
	public BookStoreResponse findById(Long id);
	public BookStoreResponse createBook(BookStoreRequest request);
}
