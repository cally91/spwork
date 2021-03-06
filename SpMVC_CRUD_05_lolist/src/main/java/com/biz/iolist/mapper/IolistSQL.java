package com.biz.iolist.mapper;

import org.apache.ibatis.jdbc.SQL;

public class IolistSQL {

	public String iolist_insert_sql() {
		
		SQL	sql=new SQL() ;
		sql.INSERT_INTO("tbl_iolist");
		sql.INTO_COLUMNS("io_seq").INTO_VALUES("#{SQL_IOLIST.NEXTVAL,tdbcType=VARCHAR}");
		sql.INTO_COLUMNS("io_date").INTO_VALUES("#{io_date,tdbcType=VARCHAR}");
		sql.INTO_COLUMNS("io_product").INTO_VALUES("#{io_product,tdbcType=VARCHAR}");
		sql.INTO_COLUMNS("io_comp").INTO_VALUES("#{io_comp,tdbcType=VARCHAR}");
		sql.INTO_COLUMNS("io_com_ceo").INTO_VALUES("#{io_com_ceo,tdbcType=VARCHAR}");
		sql.INTO_COLUMNS("io_inout").INTO_VALUES("#{io_inout,tdbcType=VARCHAR}");
		sql.INTO_COLUMNS("io_qty").INTO_VALUES("#{io_qty,tdbcType=INTGHER}");
		sql.INTO_COLUMNS("io_price").INTO_VALUES("#{io_price,tdbcType=INTGHER}");
		sql.INTO_COLUMNS("io_total").INTO_VALUES("#{io_total,tdbcType=INTGHER}");
		
		return sql.toString();
	}
	public String iolist_update_sql() {
		//bulid pattern 방식의 코드
		SQL sql =new SQL()
		.UPDATE("tbl_iolist")
		.SET("io_seq = #{io_seq}")
		.SET("io_date = #{io_date}")
		.SET("io_product = #{io_product}")
		.SET("io_comp = #{io_comp}")
		.SET("io_com_ceo = #{io_com_ceo}")
		.SET("io_inout = #{io_inout}")
		.SET("io_qty = #{io_qty}")
		.SET("io_price = #{io_price}")
		.SET("io_total = #{io_total}");
		
		return sql.toString();
	}
}
