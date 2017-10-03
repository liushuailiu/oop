package com.ysd.bbs.dao;

import com.ysd.bbs.pojo.Board;

import java.util.List;

/**
 * BBS 板块操作
 * @author fly
 */
public interface BoardDao {
	public List<Board> selectBoard();
}
