package com.biz.memo.service;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo.dao.MemberDao;
import com.biz.memo.dao.MemoDao;
import com.biz.memo.model.MemberVO;



@Service
public class MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemoService.class);
	@Autowired
	SqlSession sqlSession;
	
	MemberDao mDao;
	
	@Autowired
	public void getMapper() {
		mDao=sqlSession.getMapper(MemberDao.class);
	}


	public MemberVO login(MemberVO memberVO) {
		String m_userid =memberVO.getM_userid();
		String m_password =memberVO.getM_password();
//	 memberVO=	mDao.findByUserId(m_userid);
//	 
//	 if(memberVO.getM_password().equals(m_password)) {
//		 
//	 }
		// id와 비번을 모드 select 문으로 조회해서
		//회원 정보 가져오기
		//만약 id와 비번이 일피하면 정삭적인 vo를 리턴
	 memberVO = mDao.login(memberVO);
	 logger.debug("MEMBERVO: " +memberVO);
		return memberVO;
	}
}
