package com.ysd.bbs.dao;

import com.ysd.bbs.pojo.Users;

public interface UserDao {

	/**
	 * 通过用户名和密码查询用户
	 * @param username  用户名
	 * @param password  密 码
	 * @return  用户对象,如果找不到,则返回空
	 */

	public Users loginUser(String username, String password);

	/**
	 * 用户注册
	 * @param user 用户对象
	 * @return  成功/失败
	*/

	public boolean registerUser(Users user);

}
