package com.ex.vendingMachine.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ex.vendingMachine.dto.Product;

@Mapper
public interface ProductMapper {
	
	// 제품 목록
	List<Product> selectProudctList();
	
	// 판매 가능 제품 목록
	List<Product> selectProudctListByState(String state);
	
	// 제품 수정(상품 구입, 재고 충전, 가격 변경, 판매 상태 변경)
	int updateProduct(Product product);
	
	// 제품 추가
	int insertProduct(Product product);
	
	// 제품 검색 (제품 이름으로)
	Product selectProduct(String productName);

}
