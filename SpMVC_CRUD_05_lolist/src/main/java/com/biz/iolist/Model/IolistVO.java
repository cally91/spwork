package com.biz.iolist.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IolistVO {

	 private long io_seq;	//NUMBER
	 private String io_date;	//VARCHAR2(10)
	 private String io_product;	//nVARCHAR2(50)
	 private String io_comp;	//nVARCHAR2(50)
	 private String io_com_ceo;//	nVARCHAR2(50)
	 private String io_inout;//	nVARCHAR2(10)
	 private int io_qty;	//NUMBER
	 private int io_price;//	NUMBER
	 private int io_total;	//NUMBER

}
