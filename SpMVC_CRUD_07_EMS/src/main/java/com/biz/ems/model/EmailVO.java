package com.biz.ems.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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
public class EmailVO {
	
	private long ems_seq;
	
	@NotBlank(message = "* 받는 Eamil은 필수 항목입니다.")
	@Email(message = "* Email 형식이 잘못되었습니다")
	private String ems_to_email;
	
	@NotBlank(message = "* 보낸 Eamil은 필수 항목입니다.")
	private String ems_from_email;
	
	@NotBlank(message = "* 받는 사람 이름은 필수 항목입니다.")
	private String ems_to_name;	
	private String ems_from_name;
	private String ems_send_date;	//	VARCHAR2(10)		NOT NULL,
	private String ems_send_time;	//	VARCHAR2(20)		NOT NULL,
	
	@NotBlank(message = "* 제목은 필수 항목입니다.")
	private String ems_subject;	//	nVARCHAR2(125)		NOT NULL,
	
	@NotBlank(message = "* 내용은 필수 항목입니다.")
	private String ems_content;	//	nVARCHAR2(1000)		NOT NULL,
	private String ems_file1;	//	VARCHAR2(64)		,
	private String ems_file2;	//	VARCHAR2(64)		
}
