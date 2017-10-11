package com.ysd.bbs.view;

import com.ysd.bbs.dao.BoardDao;
import com.ysd.bbs.dao.UserDao;
import com.ysd.bbs.daoImpl.BoardDaoImpl;
import com.ysd.bbs.daoImpl.UserDaoImpl;
import com.ysd.bbs.util.MangerView;

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
			Integer choose = MangerView.firstLoginView();

		}
	}
}
