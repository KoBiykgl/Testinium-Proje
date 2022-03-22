package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookStore;

public interface BookStoreRepository 
extends JpaRepository<BookStore, Long>{


}
