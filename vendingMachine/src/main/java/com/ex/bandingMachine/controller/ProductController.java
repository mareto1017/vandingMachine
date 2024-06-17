package com.ex.bandingMachine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.bandingMachine.dto.Product;
import com.ex.bandingMachine.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	// 제품 추가
	@PostMapping("/addProduct")
	public void addProduct(Product product) {
		productService.addProduct(product);
	}
	
	// 제품 목록
	@GetMapping("/getProduct")
	public List<Product> getProudct(){
		
		return productService.getProductList();
	}
	
	// 제품 수정
	@PostMapping("/modifyProduct")
	public void modifyProduct(Product product) {
		productService.modifyProduct(product);
	}
	
	// 제품 구입
	@PostMapping("/buyProduct")
	public void buyProduct(Product product) {
		productService.buyProduct(product);
	}
}
