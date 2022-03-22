package com.example.demo.dto.response;

import com.example.demo.entity.BookStore;
import com.example.demo.entity.Category;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class AddBookResponse {
	private Long id;
	private String bookName;
	private double price;
	private Category category;
	private BookStore bookStore;
}
