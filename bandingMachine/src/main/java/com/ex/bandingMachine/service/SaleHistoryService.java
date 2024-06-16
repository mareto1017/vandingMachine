package com.ex.bandingMachine.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.bandingMachine.mapper.SaleHistoryMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class SaleHistoryService {
	
	@Autowired
	private SaleHistoryMapper saleHistoryMapper;
	
	// 제품별 수익
	public List<Map<String, Object>> getTotalPrice(){
		
		return saleHistoryMapper.selectSaleHistoryByProductName();
	}
}
