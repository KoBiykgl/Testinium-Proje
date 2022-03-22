package com.example.demo.dto.response;

import java.util.List;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookStore;
import com.example.demo.entity.Category;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateBookResponse {
//	private String bookName;
//	private double price;
//	private Category category;
//	private List<BookStore> bookStore;
	
	private Long id;
	private String bookName;
	private double price;
	Long categoryId;
	public UpdateBookResponse(Book entity) {
		this.id=entity.getId();
		this.bookName=entity.getBookName();
		this.price=entity.getPrice();
		this.categoryId=entity.getCategory().getId();
		
	}
}
