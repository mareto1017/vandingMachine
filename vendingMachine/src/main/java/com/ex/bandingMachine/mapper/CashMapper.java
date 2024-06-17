package com.ex.bandingMachine.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ex.bandingMachine.dto.Cash;

@Mapper
public interface CashMapper {
	
	// 현금 수정(현금 충전, 잔액 충전)
	int updateCash(Cash cash);
	
	// 현금 수랑 검색
	Cash selectCash();
}
