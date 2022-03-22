package com.example.demo.service.manager;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.AddBookRequest;
import com.example.demo.dto.request.BookStoreRequest;
import com.example.demo.dto.response.AddBookResponse;
import com.example.demo.dto.response.BookResponse;
import com.example.demo.dto.response.BookStoreResponse;
import com.example.demo.entity.Book;
import com.example.demo.entity.BookStore;
import com.example.demo.repo.BookRepository;
import com.example.demo.repo.BookStoreRepository;
import com.example.demo.service.BookStoreService;

@Service
public class BookStoreManager implements BookStoreService{
	
	private static final Supplier<IllegalArgumentException>
    bookStoreNotFoundExceptionSupplier = 
    () -> new IllegalArgumentException("Cannot find the bookStore");
	
	private BookStoreRepository bookStoreRepository;
	private BookRepository bookRepository;

	private ModelMapper modelMapper;

	public BookStoreManager(BookStoreRepository bookStoreRepository, ModelMapper modelMapper,BookRepository bookRepository) {
		this.bookStoreRepository = bookStoreRepository;
		this.modelMapper = modelMapper;
		this.bookRepository=bookRepository;
	}
	
	@Override
	public List<BookStoreResponse> findAll(){
		return bookStoreRepository.findAll()
				.stream()
				.map(bookStore -> modelMapper.map(bookStore, BookStoreResponse.class))
				.toList();
				
	}
	@Override
	public BookStoreResponse findById(Long id) {
		return modelMapper.map(
				bookStoreRepository.findById(id)
				.orElseThrow(bookStoreNotFoundExceptionSupplier)
				, BookStoreResponse.class);
				
	}

	@Override
	public BookStoreResponse createBook(BookStoreRequest request) {
		var bookStore = modelMapper.map(request, BookStore.class);
		return modelMapper.map(bookStoreRepository.save(bookStore), BookStoreResponse.class);
		
	}
	
	
}
