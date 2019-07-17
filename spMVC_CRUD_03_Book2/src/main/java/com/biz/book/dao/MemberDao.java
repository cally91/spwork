package com.biz.book.dao;

import java.util.List;

import com.biz.book.model.MemberVO;

public interface MemberDao {

	public List<MemberVO> selectAll();
	
	public MemberVO findByUserId(String m_userid);
	public List<MemberVO>findByName(String m_name);
	public List<MemberVO>findByTel(String m_tel);
	
	public int insert (MemberVO memberVO);
	public int updete(MemberVO memberVO);
	public int delete (String m_userid);
}
