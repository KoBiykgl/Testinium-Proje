package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dto.request.UpdateBookRequest;
import com.example.demo.entity.Book;
import com.example.demo.entity.BookStore;

import java.util.ArrayList;

import org.modelmapper.Converter;
@Configuration
public class ModelMapperConfig {
	
	
	
	
	@Bean
	public ModelMapper mapper() {
		var mapper = new ModelMapper();
		return mapper;
	}
}
