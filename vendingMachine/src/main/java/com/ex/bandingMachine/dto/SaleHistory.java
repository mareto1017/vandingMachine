package com.ex.bandingMachine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleHistory {
	private int saleNo;
	private String productName;
	private String createDate;

}
