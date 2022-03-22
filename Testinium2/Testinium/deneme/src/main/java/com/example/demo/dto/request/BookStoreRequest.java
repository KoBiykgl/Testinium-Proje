package com.example.demo.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookStoreRequest {
	private Long id;
	private String bookStoreName;
	private String city;
	
	
}
