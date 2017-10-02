package com.ysd.bbs.pojo;

import java.sql.Date;

/**
 * @author fly
 * @create 2017-10-02 13:20
 * @desc 数据库实体类, 用户回帖表
 **/
public class Reply {
	private Integer id;           //回帖主键, 生成策略为自增
	private String title;		  //回帖标题
	private String context;		  //回帖内容
	private Date t_time;          //回帖时间
	private Integer user_id;      //回帖人, 外键, 受到用户表约束
	private Integer topic_id;     //主贴ID, 外键, 受到主贴约束

	public Reply() {

	}

	public Reply(String title, String context, Date t_time, Integer user_id, Integer topic_id) {
		this.title = title;
		this.context = context;
		this.t_time = t_time;
		this.user_id = user_id;
		this.topic_id = topic_id;
	}

	@Override
	public String toString() {
		return "Reply{" +
				"id=" + id +
				", title='" + title + '\'' +
				", context='" + context + '\'' +
				", t_time=" + t_time +
				", user_id=" + user_id +
				", topic_id=" + topic_id +
				'}';
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

	public Integer getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(Integer topic_id) {
		this.topic_id = topic_id;
	}
}
