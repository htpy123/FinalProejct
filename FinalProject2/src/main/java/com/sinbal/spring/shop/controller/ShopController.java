package com.sinbal.spring.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinbal.spring.product.service.ProductService;

@Controller
public class ShopController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/shop/shop.do")
	public ModelAndView productList(HttpServletRequest request, 
			ModelAndView mView){
		
		productService.productList(request);
		//  views/shop/shop/.jsp
		mView.setViewName("shop/shop");
		return mView;
		
	}

	
}
