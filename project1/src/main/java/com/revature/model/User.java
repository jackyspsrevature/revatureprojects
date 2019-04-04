package com.revature.model;

public class User {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String userId;
	private double userRoleid;
	private String role;
	private String email;

	public User() {
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getUserRoleid() {
		return userRoleid;
	}

	public void setUserRoleid(float userRoleid) {
		this.userRoleid = userRoleid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String username, String password, String firstName, String lastName, String userId, float userRoleid,
			String role, String email) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
		this.userRoleid = userRoleid;
		this.role = role;
		this.email = email;
	}

	public User(String userId, String username, String password, String firstName, String lastName, String email,
			float userRoleid, String role) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
		this.userRoleid = userRoleid;
		this.role = role;
		this.email = email;
	}

	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(String role) {
		super();
		this.role = role;
	}

	public String toRole() {
		return role;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", userId=" + userId + ", userRoleid=" + userRoleid + ", role=" + role + ", email=" + email
				+ "]";
	}

}
