package com.ex.vendingMachine.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ex.vendingMachine.dto.SaleHistory;

@Mapper
public interface SaleHistoryMapper {

	// 판매 내역 추가
	int insertSaleHistory(SaleHistory saleHistory);
	
	// 판매 내역 조회
	List<Map<String, Object>> selectSaleHistoryByProductName();
}
