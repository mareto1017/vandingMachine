package com.ex.bandingMachine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.bandingMachine.dto.Cash;
import com.ex.bandingMachine.mapper.BalanceMapper;
import com.ex.bandingMachine.mapper.CashMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class BalanceService {

	@Autowired
	private BalanceMapper balanceMapper;
	
	@Autowired
	private CashMapper cashMapper;
	
	// 잔액 확인
	public int checkBalance() {
		int curBalance = balanceMapper.selectBalance();
		return curBalance;
	}

	
	// 잔액 충전
	public void chargeBalance(Cash cash) {
		log.debug(cash.toString());
		int row1 = cashMapper.updateCash(cash);
		if(row1 != 1) {
			throw new RuntimeException();
		}
		int money = cash.getWon10() * 10 + cash.getWon50() * 50 + cash.getWon100() * 100 + cash.getWon500() * 500 + 
				cash.getWon1000() * 1000 + cash.getWon5000() * 5000+ cash.getWon10000()* 10000 + cash.getWon50000() * 50000;
		log.debug("" + money);
		
		int row2 = balanceMapper.updateBalance(money);
		if(row2 != 1) {
			throw new RuntimeException();
		}
		
	}
	
	// 잔액 반환
	public Cash retrunBalance() {
		int money = balanceMapper.selectBalance();
		log.debug("" + money);
		
		int row1 = balanceMapper.updateBalance(-money);
		if(row1 != 1) {
			throw new RuntimeException();
		}
		Cash currentCash = cashMapper.selectCash();
		log.debug(currentCash.toString());
		
		Cash cash = new Cash();
		if(currentCash.getWon50000() >= money / 50000) {
			cash.setWon50000(-(money / 50000));
			money = money % 50000;
		}
		if(currentCash.getWon10000() >= money / 10000) {
			cash.setWon10000(-(money / 10000));
			money = money % 10000;
		}
		if(currentCash.getWon5000() >= money / 5000) {
			cash.setWon5000(-(money / 5000));
			money = money % 5000;
		}
		if(currentCash.getWon1000() >= money / 1000) {
			cash.setWon1000(-(money / 1000));
			money = money % 1000;
		}
		if(currentCash.getWon500() >= money / 500) {
			cash.setWon500(-(money / 500));
			money = money % 500;
		}
		if(currentCash.getWon100() >= money / 100) {
			cash.setWon100(-(money / 100));
			money = money % 100;
		}
		if(currentCash.getWon50() >= money / 50) {
			cash.setWon50(-(money / 50));
			money = money % 50;
		}
		if(currentCash.getWon10() >= money / 10) {
			cash.setWon10(-(money / 10));
			money = money % 10;
		}
		if(money != 0) {
			throw new RuntimeException();
		}
		log.debug(cash.toString());
		
		int row2 = cashMapper.updateCash(cash);
		if(row2 != 1) {
			throw new RuntimeException();
		}
		
		cash.setWon50000(-cash.getWon50000());
		cash.setWon10000(-cash.getWon10000());
		cash.setWon5000(-cash.getWon5000());
		cash.setWon1000(-cash.getWon1000());
		cash.setWon500(-cash.getWon500());
		cash.setWon100(-cash.getWon100());
		cash.setWon50(-cash.getWon50());
		cash.setWon10(-cash.getWon10());
		log.debug(cash.toString());
		
		
		return cash;
	}
}
