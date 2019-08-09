package com.biz.ems.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.biz.ems.model.EmailVO;

public interface EmailDao {

	@Select("SELECT * FROM tbl_ems")
	public List<EmailVO> selectAll();
	public EmailVO findBySeq(long email_seq);
	
	public List<EmailVO> fileByFrom(String ems_from);
	public List<EmailVO> fileByTo(String ems_email);
	
	/*
	 * 매개변수가 2개 이상일경우는
	 * 반드기 @param으로 변수 이름을 명시해 주어야한다.
	 */
	public List<EmailVO> fileByFromAndTo(@Param("ems_from_smail")String ems_from,@Param("ems_to_smail") String ems_to_email);
	
	public int insert(EmailVO emailVO);
	public int update(EmailVO emailVO);
	public int delete(long email_seq);
}
