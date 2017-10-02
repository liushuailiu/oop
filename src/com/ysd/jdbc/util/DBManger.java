package com.ysd.jdbc.util;

import java.sql.*;

/**
 * @author fly
 * @create 2017-09-28 13:26
 * @desc 数据库连接类
 **/
public class DBManger {

	private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=BBS";
	private static final String userName="sa";
	private static final String password="123@qwe";

	public static void closeAll(Connection connection,Statement statement ,ResultSet resultSet){

		if(resultSet!=null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(statement!=null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 执行数据库修改语句
	 * @param sql  修改语句
	 * @param strings  参数组成的字符串
	 * @return  修改是否成功
	 */
	public static boolean executeUpdate(String sql,String[] strings){
		PreparedStatement preparedStatement = null;
		QueryDataResult queryDataResult = null;
		Connection connection = getConnection();
		boolean flag = false;
		try {
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < strings.length; i++) {
				preparedStatement.setString(i+1,strings[i]);
			}
			flag = preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return flag;
		}
	}

	/**
	 * 执行数据库的查询
	 * @param sql  sql语句
	 * @param strings  参数组成的字符串
	 * @return  结果集
	 */
	public static QueryDataResult executeQuery(String sql,String[] strings){
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		QueryDataResult queryDataResult = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < strings.length; i++) {
				preparedStatement.setString(i+1,strings[i]);
			}
			resultSet = preparedStatement.executeQuery();
			queryDataResult = new QueryDataResult(connection,preparedStatement,resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return queryDataResult;
		}
	}


	/**
	 * 获得数据库连接对象
	 * @return Connection
	 * @author fly
	 */
	public static Connection getConnection(){
		Connection connection = null;
		try {
			//加载数据库驱动
			Class.forName(driver);
			//连接数据库
			connection = DriverManager.getConnection(url,userName,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("无法加载驱动");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("无法连接数据库");
		}finally {
			return connection;
		}
	}


}
