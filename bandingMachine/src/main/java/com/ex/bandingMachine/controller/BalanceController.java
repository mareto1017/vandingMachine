package com.ex.bandingMachine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.bandingMachine.dto.Cash;
import com.ex.bandingMachine.service.BalanceService;

@RestController
public class BalanceController {
	
	@Autowired
	private BalanceService balanceService;
	
	// 잔액 충전
	@PostMapping("/chargeBalance")
	public void chargeBalance(Cash cash) {
		balanceService.chargeBalance(cash);
	}
	
	// 잔액 반환
	@GetMapping("/returnBalance")
	public Cash returnBalance() {
		return balanceService.retrunBalance();
	}

}
