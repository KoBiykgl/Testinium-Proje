package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "bookStore")
@DynamicUpdate
@Data
@NoArgsConstructor
public class BookStore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String bookStoreName;
	private String city;
	
	
//	@OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
//	@JsonIgnore
//	private List<Book> book;
	
//	@ManyToOne(cascade = CascadeType.REMOVE, 
//			fetch = FetchType.LAZY)
//	private Book book;
	
	
}
