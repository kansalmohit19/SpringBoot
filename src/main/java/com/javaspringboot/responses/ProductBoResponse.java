package com.javaspringboot.responses;

import java.util.List;

import com.javaspringboot.entities.ProductEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductBoResponse {
	
	public Long totalCount;
	public int totalPages;
	public List<ProductEntity> listOfProducts;

}
