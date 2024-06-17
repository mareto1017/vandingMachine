package com.ex.vendingMachine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.vendingMachine.dto.Cash;
import com.ex.vendingMachine.service.CashService;

@RestController
public class CashController {

	@Autowired
	private CashService cashService;
	
	@GetMapping("/getCash")
	public Cash getCash() {
		return cashService.getCash();
	}
	
	@PostMapping("/modifyCash")
	public void modifyCash(Cash cash) {
		cashService.modifyCash(cash);
	}
}
