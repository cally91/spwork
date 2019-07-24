package com.biz.iolist.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CompVO {
	private String c_code;
	private String c_name;
	private String c_ceo;
	private String c_tel;
	private String c_addr;
}
