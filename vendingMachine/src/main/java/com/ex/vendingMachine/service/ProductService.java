package com.ex.vendingMachine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.vendingMachine.dto.Product;
import com.ex.vendingMachine.dto.SaleHistory;
import com.ex.vendingMachine.mapper.BalanceMapper;
import com.ex.vendingMachine.mapper.ProductMapper;
import com.ex.vendingMachine.mapper.SaleHistoryMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private BalanceMapper balanceMapper;
	
	@Autowired
	private SaleHistoryMapper saleHistoryMapper;
	
	// 제품 추가
	public void addProduct(Product product) {
		log.debug(product.toString());
		
		productMapper.insertProduct(product);
		
	}
	
	// 제품 목록
	public List<Product> getProductList(){
		
		return productMapper.selectProudctList();
	}
	
	// 제품 재고, 가격 수정
	public void modifyProduct(Product product) {
		log.debug(product.toString());
		productMapper.updateProduct(product);
	}
	
	// 제품 구입
	public void buyProduct(Product product) {
		product = productMapper.selectProduct(product.getProductName());
		product.setStock(-1);
		log.debug(product.toString());
		int row1 = productMapper.updateProduct(product);
		if(row1 != 1) {
			throw new RuntimeException();
		}
		
		int row2 = balanceMapper.updateBalance(-product.getPrice());
		if(row2 != 1) {
			throw new RuntimeException();
		}
		
		SaleHistory saleHistory = new SaleHistory();
		saleHistory.setProductName(product.getProductName());
		log.debug(saleHistory.toString());
		
		int row3 = saleHistoryMapper.insertSaleHistory(saleHistory);
		if(row3 != 1) {
			throw new RuntimeException();
		}
	}

}
