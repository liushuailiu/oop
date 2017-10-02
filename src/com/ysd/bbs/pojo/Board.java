package com.ysd.bbs.pojo;

/**
 * @author fly
 * @create 2017-10-02 12:58
 * @desc 数据库实体类, 论坛版块表
 **/
public class Board {

	private Integer id;   // 板块ID ,主键自增模式
	private String name;  // 板块名称

	public Board() {
	}

	public Board(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Board{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
