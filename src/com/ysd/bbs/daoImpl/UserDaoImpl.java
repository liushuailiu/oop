package com.ysd.bbs.daoImpl;

import com.ysd.bbs.dao.UserDao;
import com.ysd.bbs.pojo.Users;
import com.ysd.jdbc.util.JDBCUtils;

/**
 * @author fly
 * @create 2017-10-02 18:16
 * @desc 用户操作类
 **/
public class UserDaoImpl implements UserDao {

	/**
	 * 用户登录
	 * @param username  用户名
	 * @param password  密 码
	 * @return 查询到的用户对象
	 */
	@Override
	public Users loginUser(String username, String password) {
		String sql = "SELECT * FROM dbo.users WHERE name = ? AND pass = ? ";
		Users users = JDBCUtils.get(sql,Users.class,username,password);
		return users;
	}

	/**
	 * 用户注册
	 * @param user 用户对象
	 * @return  成功/失败
	 */
	@Override
	public boolean registerUser(Users user) {
		String sql = "INSERT INTO dbo.users VALUES (?, ?, ?, ?)";
		boolean flag = JDBCUtils.update(sql,user.getName(),user.getPass(),user.getState(),user.getFlag());
		return flag;
	}
}
