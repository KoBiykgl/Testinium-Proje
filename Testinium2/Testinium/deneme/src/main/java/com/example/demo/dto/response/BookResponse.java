package com.example.demo.dto.response;

import java.util.List;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookStore;
import com.example.demo.entity.Category;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookResponse {

	private Long id;
	private String bookName;
	private double price;
	String category;
	private List<BookStore> bookStore;
	

	
	
}
