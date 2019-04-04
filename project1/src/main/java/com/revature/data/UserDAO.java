package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.User;
import com.revature.util.ConnectionFactory;

public class UserDAO {

	public UserDAO() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * public List<User> getUsers() { List<User> users = new ArrayList<User>(); try
	 * (Connection conn = ConnectionFactory.getInstance().getConnection()) { String
	 * query = "Select * from ERS_USERS"; Statement statement =
	 * conn.createStatement(); ResultSet rs = statement.executeQuery(query); while
	 * (rs.next()) { User temp = new User(rs.getInt("USER_ROLE_ID"),
	 * rs.getString("ERS_USERNAME"), rs.getString("ERS_PASSWORD")); users.add(temp);
	 * } } catch (SQLException e) { e.printStackTrace(); } return users; }
	 */

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT ERS_USERS.*,ERS_USER_ROLES.USER_ROLE FROM ERS_USERS LEFT JOIN ERS_USER_ROLES on ERS_USERS.USER_ROLE_ID= ERS_USER_ROLES.ERS_USER_ROLE_ID";
			Statement pxs = conn.createStatement();
			ResultSet rxs = pxs.executeQuery(sql);
			while (rxs.next()) {
				User tempa = new User(rxs.getString("ERS_USERS_ID"), rxs.getString("ERS_USERNAME"),
						rxs.getString("ERS_PASSWORD"), rxs.getString("USER_FIRST_NAME"),
						rxs.getString("USER_LAST_NAME"), rxs.getString("USER_EMAIL"), rxs.getFloat("USER_ROLE_ID"),
						rxs.getString("USER_ROLE"));
				users.add(tempa);
//				System.out.println(users);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
//		System.out.println(users);
		return users;
	}

	public static boolean Login(String username, String password) {
		boolean statusMessage = false;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ? and ERS_PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			statusMessage = rs.next();
			System.out.println(statusMessage);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return statusMessage;
	}

	public User getByRole(String username) {
		User u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT ERS_USERS.*,ERS_USER_ROLES.USER_ROLE FROM ERS_USERS LEFT JOIN ERS_USER_ROLES on ERS_USERS.USER_ROLE_ID = ERS_USER_ROLES.ERS_USER_ROLE_ID WHERE ERS_USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			// System.out.println(ps.executeQuery());
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {
				// u = new User(rs.getString("USER_ROLE"));
				// System.out.println(u);
				// System.out.print(rs.getString(1));
				u = new User(rs.getString("ERS_USERS_ID"), rs.getString("ERS_USERNAME"), rs.getString("ERS_PASSWORD"),
						rs.getString("USER_FIRST_NAME"), rs.getString("USER_LAST_NAME"), rs.getString("USER_EMAIL"),
						rs.getFloat("USER_ROLE_ID"), rs.getString("USER_ROLE"));
//				System.out.println(u);
//				PrintWriter out = new PrintWriter(System.out);
//				out.print(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
//		PrintWriter out = new PrintWriter(System.out);
//		out.print(u);
		return u;
	}

}
