package com.ysd.jdbc.util;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.sql.*;
import java.util.List;

/**
 * @author fly
 * @create 2017-09-28 18:08
 * @desc 采用 dbUtils 实现数据查询
 **/
public class JDBCUtils {

	/**
	 * 获取自增主键
	 * @param sql 插入语句
	 * @param objects 所需参数
	 * @return 主键
	 * @author fly
	 */
	public static Integer getGeneratedKey(String sql,Object... objects){
		Connection connection = DBManger.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Integer key = 0;
		try {
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < objects.length; i++) {
				preparedStatement.setString(i+1, (String) objects[i]);
			}
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			key = resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManger.closeAll(connection,preparedStatement,resultSet);
			return key;
		}
	}

	/**
	 * 批量操作/批处理
	 * @param sql 数据库插入语句
	 * @param params SQL语句需要参数
	 * @return 受影响的数据信息
	 */
	public static int[] batch(String sql,Object[][] params){
		Connection connection = DBManger.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		int[] i = null;
		try {
			i = queryRunner.batch(connection,sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(connection);
			return i;
		}
	}

	/**
	 * 数据库修改
	 * @param sql  数据库修改语句
	 * @param objects sql语句需要参数
	 * @return 成功与否
	 * @author fly
	 */
	public static boolean update(String sql,Object... objects){
		Connection connection = DBManger.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		boolean flag = false;
		try {
			int result = queryRunner.update(connection,sql,objects);
			if(result>0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(connection);
			return flag;
		}
	}

	/**
	 * 查询数据库,返回单个对象
	 * @param sql 数据库查询语句
	 * @param clazz  返回对象类型
	 * @param objects  sql参数
	 * @param <T> 泛型
	 * @return 单个java对象
	 * @author fly
	 */
	public static <T> T get(String sql,Class clazz,Object... objects){
		Connection connection = DBManger.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		Object bean = null;
		try {
			bean = queryRunner.query(connection,sql,new BeanHandler<Object>(clazz),objects);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(connection);
			return (T) bean;
		}
	}

	/**
	 * 数据库查询,返回对象集合
	 * @param sql  查询语句
	 * @param clazz  声明返回对象类型
	 * @param objects  sql参数
	 * @param <E> 泛型使用
	 * @return  集合类型
	 * @author fly
	 */

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

	/**
	 * 查询单列的值
	 * @param sql  查询语句
	 * @param index 要查询列的索引
	 * @param objects sql所需参数
	 * @return 返回该列的值
	 * @author fly
	 */
	public static Object getColumn(String sql,Integer index,Object... objects){
		Connection connection = DBManger.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		Object bean = null;
		try {
			bean = queryRunner.query(connection,sql,new ScalarHandler(index),objects);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeQuietly(connection);
			return bean;
		}

	}


}
