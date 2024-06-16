package com.ex.bandingMachine.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BalanceMapper {
	
	//잔액 수정(잔액 충전, 잔돈 반환, 상품 구매)
	int updateBalance(int money);
	
	//잔액 검색
	int selectBalance();
}
