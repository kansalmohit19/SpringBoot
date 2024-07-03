package com.javaspringboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String name;
	private double price;
	private String description;
	private Integer quantity;
	private Boolean isStock;
	private String barcode;

	// many to one
	@ManyToOne
	@JoinColumn(name = "cat_id", nullable = false)
	private CategoryEntity category;

}
