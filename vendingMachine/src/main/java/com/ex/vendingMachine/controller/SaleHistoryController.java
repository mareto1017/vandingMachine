package com.ex.vendingMachine.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.vendingMachine.service.SaleHistoryService;

@RestController
public class SaleHistoryController {

	@Autowired
	private SaleHistoryService saleHistoryService;
	
	@GetMapping("/getTotalPrice")
	public List<Map<String, Object>> getTotalPrice(){
		return saleHistoryService.getTotalPrice();
	}
}
