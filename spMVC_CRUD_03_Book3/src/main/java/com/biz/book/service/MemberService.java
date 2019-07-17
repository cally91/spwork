package com.biz.book.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.book.dao.MemberDao;
import com.biz.book.model.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	SqlSession sqlSession;
	/*
	 * 회원 가입정책
	 * 1. 최초로 회원 가입을 하면 그 회원을 ADMIN으로 설정
	 * 2. 그 후에 가입한 회원은 USER로 설정
	 */
	
	 
	public int insert(MemberVO memberVO) {
		MemberDao mDao = sqlSession.getMapper(MemberDao.class);
		List<MemberVO> mList =mDao.selectAll();
		if(mList.size()>0) memberVO.setM_role("UESR");
		else  memberVO.setM_role("ADMIN");
		int ret =mDao.insert(memberVO);
		return ret;
	}


	public boolean member_check(String m_userid, String m_password) {
		MemberDao mDao =sqlSession.getMapper(MemberDao.class);
		MemberVO memberVO = mDao.findByUserId(m_userid);
		
		if(memberVO.getM_userid().equalsIgnoreCase(m_userid) && memberVO.getM_password().equals(m_password)) {
			return true;
		}
		
		return false;
	}


	public MemberVO findByUserId(String m_userid) {
		MemberDao mDao= sqlSession.getMapper(MemberDao.class);
		MemberVO memberVO =mDao.findByUserId(m_userid);
		return memberVO;
		//return null;
	}


}
