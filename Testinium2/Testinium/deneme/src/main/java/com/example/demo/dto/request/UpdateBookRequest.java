package com.example.demo.dto.request;

import com.example.demo.entity.Category;

import lombok.Data;

@Data

public class UpdateBookRequest {
	
//	private String bookName;
//	private double price;
//	private Category category;
//	private List<BookStore> bookStore;
	private Category category;

}
