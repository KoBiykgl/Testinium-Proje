package com.example.demo.dto.response;

import com.example.demo.entity.Book;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookStoreResponse {

	private Long id;
	private String bookStoreName;
	private String city;
	
	
	
}
