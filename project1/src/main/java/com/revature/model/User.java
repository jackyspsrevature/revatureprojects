package com.revature.model;

public class User {
	private float roleid;

	public User(float roleid, String username, String password) {
		super();
		this.roleid = roleid;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [roleid=" + roleid + ", username=" + username + ", password=" + password + "]";
	}

	private String username;

	public float getRoleid() {
		return roleid;
	}

	public void setRoleid(float roleid) {
		this.roleid = roleid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;

}
