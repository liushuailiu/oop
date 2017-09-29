package com.ysd.jdbc.test;

import com.ysd.jdbc.util.DBManger;
import com.ysd.jdbc.util.JDBCUtils;
import com.ysd.jdbc.util.QueryDataResult;
import com.ysd.pojo.User;
import org.junit.Test;

import java.sql.*;
import java.util.List;

/**
 * @author fly
 * @create 2017-09-28 16:14
 * @desc 数据库测试类
 **/
public class JDBCTest {

	//获取自增主键
	@Test
	public void testKey(){
		String sql = "insert into Student values(?,?)";
		Integer key = JDBCUtils.getGeneratedKey(sql,"张三","123456");
		System.out.println(key);
	}

	//批处理测试
	@Test
	public void testBatch(){
		Object[][] objects = {{"林冲","123"},{"武松","321"},{"鲁智深","456"}};
		String sql = "insert into Student values(?,?)";
		int[] i = JDBCUtils.batch(sql,objects);
		System.out.println(i.length);
	}
	//测试
	@Test
	public void testQuery(){
		String sql = "select * from Student where id = ? ";
		String[] strings = {"1"};
		List<User> list = JDBCUtils.query(sql,User.class,strings);
		for (User u:list) {
			System.out.println(u.toString());
		}
	}

	public static void testDBManger(){
		String sql = "select * from StudentInfo where StudentName= ? and ClassID = ?";
		String[] strings = {"马钰","1"};
		QueryDataResult queryDataResult = DBManger.executeQuery(sql,strings);
		ResultSet resultSet = queryDataResult.getResultSet();
		try {
			while (resultSet.next()){
				String name = resultSet.getString(2);
				Date birthday = resultSet.getDate(5);
				System.out.println("姓名:"+name+"生日:"+birthday);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			queryDataResult.closeAll();
		}
	}
}
