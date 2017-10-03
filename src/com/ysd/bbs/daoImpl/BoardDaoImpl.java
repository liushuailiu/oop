package com.ysd.bbs.daoImpl;

import com.ysd.bbs.dao.BoardDao;
import com.ysd.bbs.pojo.Board;
import com.ysd.jdbc.util.JDBCUtils;

import java.util.List;

/**
 * @author fly
 * @create 2017-10-03 10:23
 * @desc BBS 板块操作
 **/
public class BoardDaoImpl implements BoardDao {

	/**
	 * 板块查询, 查询板块表所有数据
	 * @return 板块对象
	 */
	@Override
	public List<Board> selectBoard() {
		String sql = "SELECT * FROM board";
		List<Board> list = JDBCUtils.query(sql,Board.class);
		return list;
	}
}
