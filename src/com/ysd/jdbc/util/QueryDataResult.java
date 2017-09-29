package com.ysd.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author fly
 * @create 2017-09-28 13:53
 * @desc JDBC操作数据库得到的返回结果集
 **/
public class QueryDataResult {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;



	//初始化返回结果集
	public QueryDataResult(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		this.connection = connection;
		this.preparedStatement = preparedStatement;
		this.resultSet = resultSet;
	}

	//关闭数据库连接
	public void closeAll(){
		if(this.resultSet==null){
			try {
				this.resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(this.preparedStatement==null){
			try {
				this.preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(this.connection==null){
			try {
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

}
