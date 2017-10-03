package com.ysd.bbs.view;

import com.ysd.bbs.dao.BoardDao;
import com.ysd.bbs.dao.UserDao;
import com.ysd.bbs.daoImpl.BoardDaoImpl;
import com.ysd.bbs.daoImpl.UserDaoImpl;
import com.ysd.bbs.pojo.Board;
import com.ysd.bbs.pojo.Users;

import java.util.List;
import java.util.Scanner;

/**
 * @author fly
 * @create 2017-10-02 18:43
 * @desc 欢迎来到论坛管理系统
 **/
public class BBSAdmin {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UserDao userDao = new UserDaoImpl();
		BoardDao boardDao = new BoardDaoImpl();
		while (true){
			System.out.println("欢迎来到BBS论坛");
			System.out.println("1:已有账号!请直接登录!!!  2:没有账号?请先注册!!!");
			Integer choose = scanner.nextInt();
			switch (choose){
				case 1:
					System.out.println("请输入您的账号");
					String username = scanner.next();
					System.out.println("请输入您的密码");
					String password = scanner.next();
					Users user = userDao.loginUser(username,password);
					if(user==null){
						System.out.println("您的输入有误,请检查您的用户名或者密码");
						break;
					}
					if(user.getState()==0){
						System.out.println("欢迎您,"+user.getName()+"!!!");
					}else {
						System.out.println("欢迎您,"+user.getName()+"管理员!!!");
						System.out.println("请选择你要进行的操作");
						System.out.println(" 1:查看所有发帖 2:查看所有用户 3:封禁用户 4:删除发帖  5:板块管理 ");
						Integer admin_choose = scanner.nextInt();
						switch (admin_choose){
							case 1:
								break;
							case 5:
								System.out.println("请选择您要进行的操作");
								System.out.println(" 1:查看所有板块  2:修改板块  3:删除板块  4:添加板块 ");
								Integer board_choose = scanner.nextInt();
								switch (board_choose){
									case 1:
										List<Board> boardList = boardDao.selectBoard();
										for (Board board:boardList) {
											System.out.println(board.toString());
										}
										break;
									default:
										break;
								}
								break;
							default:
								break;
						}
					}
					break;
				case 2:
					break;
				default:
					System.out.println("您的输入有误!!!");
					break;
			}
		}
	}
}
