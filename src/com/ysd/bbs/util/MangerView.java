package com.ysd.bbs.util;

import com.ysd.bbs.dao.UserDao;
import com.ysd.bbs.daoImpl.UserDaoImpl;
import com.ysd.bbs.pojo.Users;

import java.util.Scanner;

/**
 * @author fly
 * @create 2017-10-11 8:45
 * @desc 视图, 提示用户输入各种数据
 **/
public class MangerView {
	private static Scanner scanner = new Scanner(System.in);
	private static UserDao dao = new UserDaoImpl();

	/**
	 * 用户首次进入BBS系统,给出欢迎提示
	 * @return 获得用户的选择
	 */
	public static Integer firstLoginView(){
		System.out.println("欢迎来到BBS论坛");
		System.out.println("1.管理员登录  2.普通用户登录  3.注册");
		Integer choose = scanner.nextInt();
		return choose;
	}

	/**
	 * 根据用户首次选择,做出相应判断,
	 * 1--代表管理员登录
	 * 2--代表用户登录
	 * 3--代表注册
	 * @param choose
	 */
	public static void loginOrRegister(Integer choose){
		switch (choose){
			case 1:
				boolean flag = adminLogin();
				if(flag){
					//管理员成功登录

				}else{
					//管理员登录失败

				}
				break;
			default:
				break;
		}
	}

	/**
	 * 管理员成功登录,
	 * 提示他要进行的操作
	 * 1--用户管理
	 * 2--板块管理
	 * 3--主贴管理
	 * 4--统计汇总
	 * @return  管理员的选择
	 */
	public static Integer adminLoginSuccessful(){
		System.out.println("1--用户管理 2--板块管理 3--主贴管理 4--统计汇总");
		Integer choose = scanner.nextInt();
		switch (choose){
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				break;
		}
		return choose;
	}

	public static boolean adminLogin(){
		System.out.println("请输入您的用户名");
		String name = scanner.next();
		System.out.println("请输入您的密码");
		String pass = scanner.next();
		Users user = dao.loginUser(name,pass);
		if(user==null){
			return false;
		}else {
			return true;
		}
	}

}
