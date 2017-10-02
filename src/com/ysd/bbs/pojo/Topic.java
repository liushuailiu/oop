package com.ysd.bbs.pojo;

import java.sql.Date;

/**
 * @author fly
 * @create 2017-10-02 13:12
 * @desc 数据库实体类, 用户发帖表
 **/
public class Topic {

	private Integer id;			 //帖子主键, 生成策略为自增
	private String title;      	 //帖子标题
	private String context;      //帖子内容
	private Date t_time;		 //发帖时间
	private Integer user_id;     //外键, 受到用户表约束
	private Integer board_id;    //外键, 受到板块表约束

	public Topic(String title, String context, Date t_time, Integer user_id, Integer board_id) {
		this.title = title;
		this.context = context;
		this.t_time = t_time;
		this.user_id = user_id;
		this.board_id = board_id;
	}

	public Topic() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getT_time() {
		return t_time;
	}

	public void setT_time(Date t_time) {
		this.t_time = t_time;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getBoard_id() {
		return board_id;
	}

	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}

	@Override
	public String toString() {
		return "Topic{" +
				"id=" + id +
				", title='" + title + '\'' +
				", context='" + context + '\'' +
				", t_time=" + t_time +
				", user_id=" + user_id +
				", board_id=" + board_id +
				'}';
	}
}
