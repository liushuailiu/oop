package com.ysd.bbs.pojo;

/**
 * @author fly
 * @create 2017-10-02 12:51
 * @desc  数据库实体类,用户管理
 **/
public class Users {

	private Integer id;            // 用户ID, 主键自增模式
	private String name; 		   // 用户名称
	private String pass;		   // 用户密码
	private Integer state;		   // 用户角色  1--管理员  0--普通用户
	private Integer flag;		   // 用户状态  1--启用    0--禁用

	public Users() {
	}

	public Users(String name, String pass, Integer state, Integer flag) {
		this.name = name;
		this.pass = pass;
		this.state = state;
		this.flag = flag;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Users{" +
				"id=" + id +
				", name='" + name + '\'' +
				", pass='" + pass + '\'' +
				", state=" + state +
				", flag=" + flag +
				'}';
	}
}
