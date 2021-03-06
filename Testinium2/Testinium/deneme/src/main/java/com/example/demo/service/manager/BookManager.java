package com.example.demo.service.manager;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.AddBookRequest;
import com.example.demo.dto.request.UpdateBookRequest;
import com.example.demo.dto.response.AddBookResponse;
import com.example.demo.dto.response.BookResponse;
import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepository;
import com.example.demo.service.BookService;

@Service

public class BookManager implements BookService{

	private static final Supplier<IllegalArgumentException>
    bookNotFoundExceptionSupplier = 
    () -> new IllegalArgumentException("Cannot find the book");
	
	private BookRepository bookRepository;

	private ModelMapper modelMapper;
	

	public BookManager(BookRepository bookRepository, ModelMapper modelMapper) {
		this.bookRepository = bookRepository;
		
		this.modelMapper = modelMapper;
	}
	
	@Override
	public BookResponse findById(Long id) {
		return modelMapper.map(
				bookRepository.findById(id)
				.orElseThrow(bookNotFoundExceptionSupplier)
				, BookResponse.class);
				
	}
	@Override
	public List<BookResponse> findAll(){
		return bookRepository.findAll()
				.stream()
				.map(bookStore -> modelMapper.map(bookStore, BookResponse.class))
				.toList();
				
	}
	
	@Override
	
	public AddBookResponse createBook(AddBookRequest request) {
		var book = modelMapper.map(request, Book.class);
		return modelMapper.map(bookRepository.save(book), AddBookResponse.class);
		
	}
	@Override
	public Book updateOneBookById(Long bookId, UpdateBookRequest updateBookRequest) {
		Optional<Book> bookdb = bookRepository.findById(bookId);
		if(bookdb.isPresent()) {
			var toUpdate = bookdb.get();
			toUpdate.setCategory(updateBookRequest.getCategory());
			bookRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}
	
	@Override
	public BookResponse removeById(Long id) {
		var book = bookRepository.findById(id);
		if(book == null)
			book.orElseThrow(bookNotFoundExceptionSupplier);
		 bookRepository.deleteById(id);
		 return modelMapper.map(Book.class, BookResponse.class);
		 
	}

	@Override
	public List<BookResponse> getAllBookCategoryId(Long categoryId) {
		return bookRepository.findAllBookByCategoryId(categoryId)
				.stream()
				.map(book -> modelMapper.map(book, BookResponse.class))
				.sorted(Comparator.comparing(BookResponse::getBookName))
				.toList();
	}

	@Override
	public List<BookResponse> getAllBookByBookStoreId(Long bookStoreId) {
		return bookRepository.findAllBookByBookStoreId(bookStoreId)
				.stream()
				.map(book -> modelMapper.map(book, BookResponse.class))
				.sorted(Comparator.comparing(BookResponse::getBookName))
				.toList();
	}

	@Override
	
	public Book removeTheBookFromTheBookStore(Long bookId,Long bookStoreId) {
		
		return bookRepository.deleteByIdAndBookStoreId(bookId,bookStoreId);
	}

	
	
}
