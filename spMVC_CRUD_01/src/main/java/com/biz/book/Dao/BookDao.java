package com.biz.book.Dao;

import java.util.List;

import com.biz.book.model.BookVO;

public interface BookDao {

	public List<BookVO> selectall();
	public BookVO findBySeq(long b_sep);
	public List<BookVO> findByTitle(String  b_title) ;
	
	public int insert(BookVO bookVO);
	public int update(BookVO bookVO);
	public int delete(long b_sep);
	
}
