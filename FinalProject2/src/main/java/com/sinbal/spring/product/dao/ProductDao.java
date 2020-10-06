package com.sinbal.spring.product.dao;

import java.util.List;

import com.sinbal.spring.product.dto.ProductDto;

public interface ProductDao {
	public void insert(ProductDto dto);
	public List<ProductDto> getList();
	public List<ProductDto> productList(ProductDto dto);
	public int getCount(ProductDto dto);
}
