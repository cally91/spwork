package com.biz.iolist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.ui.Model;

import com.biz.iolist.Model.IolistVO;

public interface IolistDao {

	@Select(" SELECT * FROM tbl_iolist ")
	public List<IolistVO> selectAll() ;
	
	@InsertProvider(type = IolistSQL.class,method = "iolist_insert_sql")
	public int insert(IolistVO loIolistVO);
	
	@UpdateProvider(type = IolistSQL.class,method = "iolist_update_sql")
	public int update(IolistVO iolistVO);
		
	@Delete(" DELETE FROM tbl_iolist WHERE io_seq = #{io_seq} ")
	public int delete(long io_seq);
	
}
