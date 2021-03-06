package com.example.demo.dto.request;

import java.util.List;

import com.example.demo.entity.BookStore;
import com.example.demo.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBookRequest {

	
	private Long id;
	private String bookName;
	private double price;
	private Category category;
	private List<BookStore> bookStore;
}