package com.ysd.jdbc.util;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author fly
 * @create 2017-09-28 18:08
 * @desc 采用 dbUtils 实现数据查询
 **/
public class JDBCUtils {

	@Nullable
	public static <E> List<E> query(String sql, Class clazz,Object... objects){
		Connection connection = DBManger.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		List<Object> list = null;
		try {
			list = queryRunner.query(connection,sql,new BeanListHandler<Object>(clazz),objects);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(connection);
		}
		return (List<E>) list;
	}
}
