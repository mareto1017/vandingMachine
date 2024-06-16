package com.ex.bandingMachine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.bandingMachine.dto.Cash;
import com.ex.bandingMachine.mapper.CashMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class CashService {

	@Autowired
	private CashMapper cashMapper;
	
	// 현금 재고 출력
	public Cash getCash() {
		return cashMapper.selectCash();
	}
	
	// 현금 재고 수정
	public void modifyCash(Cash cash) {
		log.debug(cash.toString());
		cashMapper.updateCash(cash);
	}
}
