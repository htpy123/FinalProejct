package com.sinbal.spring.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinbal.spring.product.dto.ProductDto;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(ProductDto dto) {
		session.insert("product.addProduct",dto);
	}

	@Override
	public List<ProductDto> getList() {
		
		return session.selectList("product.getList");
	}

	@Override
	public List<ProductDto> productList(ProductDto dto) {
		
		return session.selectList("product.productList", dto);
	}
	
	@Override
	public List<ProductDto> productListSearch(ProductDto dto) {
		
		return session.selectList("product.productListSearch", dto);
	}
	
	@Override
	public int getCount(ProductDto dto) {

		return session.selectOne("product.getCount", dto);
	}
	
	
}
