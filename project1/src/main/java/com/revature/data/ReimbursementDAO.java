package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.util.ConnectionFactory;

public class ReimbursementDAO {
	public ReimbursementDAO() {
	}

	public static List<Reimbursement> getReimbursement() {
		List<Reimbursement> users = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT ERS_REIMBURSEMENT.*, ERS_REIMBURSEMENT_TYPE.REIMB_TYPE, ERS_REIMBURSEMENT_STATUS.REIMB_STATUS FROM ERS_REIMBURSEMENT LEFT JOIN ERS_REIMBURSEMENT_STATUS on ERS_REIMBURSEMENT_STATUS.REIMB_STATUS_ID = ERS_REIMBURSEMENT.REIMB_STATUS_ID LEFT JOIN ERS_REIMBURSEMENT_TYPE on ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_ID = ERS_REIMBURSEMENT.REIMB_TYPE_ID";
			// String sql = "SELECT ERS_REIMBURSEMENT.*, ERS_REIMBURSEMENT_TYPE.REIMB_TYPE,
			// ERS_REIMBURSEMENT_STATUS.REIMB_STATUS, ERS_USERS.ERS_USERNAME FROM
			// ERS_REIMBURSEMENT LEFT JOIN ERS_REIMBURSEMENT_STATUS on
			// ERS_REIMBURSEMENT_STATUS.REIMB_STATUS_ID = ERS_REIMBURSEMENT.REIMB_STATUS_ID
			// LEFT JOIN ERS_REIMBURSEMENT_TYPE on ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_ID =
			// ERS_REIMBURSEMENT.REIMB_TYPE_ID LEFT JOIN ERS_USERS on ERS_USERS.ERS_USERS_ID
			// = ERS_REIMBURSEMENT.REIMB_AUTHOR ";
			Statement pxs = conn.createStatement();
			ResultSet rxs = pxs.executeQuery(sql);
			while (rxs.next()) {
				Reimbursement tempa = new Reimbursement(rxs.getString("REIMB_ID"), rxs.getDouble("REIMB_AMOUNT"),
						rxs.getTimestamp("REIMB_SUBMITTED"), rxs.getTimestamp("REIMB_RESOLVED"),
						rxs.getString("REIMB_DESCRIPTION"), rxs.getBytes("REIMB_RECIPT"), rxs.getString("REIMB_AUTHOR"),
						rxs.getString("REIMB_RESOLVER"), rxs.getDouble("REIMB_STATUS_ID"),
						rxs.getDouble("REIMB_TYPE_ID"), rxs.getString("REIMB_TYPE"), rxs.getString("REIMB_STATUS"));
				users.add(tempa);
//				System.out.println(users);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(users);
		return users;
	}

	public static List<Reimbursement> resolved() {
		List<Reimbursement> users = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT ERS_REIMBURSEMENT.*, ERS_REIMBURSEMENT_TYPE.REIMB_TYPE, ERS_REIMBURSEMENT_STATUS.REIMB_STATUS FROM ERS_REIMBURSEMENT LEFT JOIN ERS_REIMBURSEMENT_STATUS on ERS_REIMBURSEMENT_STATUS.REIMB_STATUS_ID = ERS_REIMBURSEMENT.REIMB_STATUS_ID LEFT JOIN ERS_REIMBURSEMENT_TYPE on ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_ID = ERS_REIMBURSEMENT.REIMB_TYPE_ID WHERE REIMB_STATUS = 'resolved' OR (REIMB_STATUS = 'denied') ";
			Statement pxs = conn.createStatement();
			ResultSet rxs = pxs.executeQuery(sql);
			while (rxs.next()) {
				Reimbursement tempa = new Reimbursement(rxs.getString("ERS_USERS_ID"), rxs.getDouble("REIMB_AMOUNT"),
						rxs.getTimestamp("REIMB_SUBMITTED"), rxs.getTimestamp("REIMB_RESOLVED"),
						rxs.getString("REIMB_DESCRIPTION"), rxs.getBytes("REIMB_RECIPT"), rxs.getString("REIMB_AUTHOR"),
						rxs.getString("REIMB_RESOLVER"), rxs.getDouble("REIMB_STATUS_ID"),
						rxs.getDouble("REIMB_TYPE_ID"), rxs.getString("REIMB_TYPE"), rxs.getString("REIMB_STATUS"));
				users.add(tempa);
				System.out.println(users);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return users;
	}

	public static List<Reimbursement> unresolved() {
		List<Reimbursement> users = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT ERS_REIMBURSEMENT.*, ERS_REIMBURSEMENT_TYPE.REIMB_TYPE, ERS_REIMBURSEMENT_STATUS.REIMB_STATUS FROM ERS_REIMBURSEMENT LEFT JOIN ERS_REIMBURSEMENT_STATUS on ERS_REIMBURSEMENT_STATUS.REIMB_STATUS_ID = ERS_REIMBURSEMENT.REIMB_STATUS_ID LEFT JOIN ERS_REIMBURSEMENT_TYPE on ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_ID = ERS_REIMBURSEMENT.REIMB_TYPE_ID WHERE REIMB_STATUS = 'unresolved' ";
			Statement pxs = conn.createStatement();
			ResultSet rxs = pxs.executeQuery(sql);
			while (rxs.next()) {
				Reimbursement tempa = new Reimbursement(rxs.getString("ERS_USERS_ID"), rxs.getDouble("REIMB_AMOUNT"),
						rxs.getTimestamp("REIMB_SUBMITTED"), rxs.getTimestamp("REIMB_RESOLVED"),
						rxs.getString("REIMB_DESCRIPTION"), rxs.getBytes("REIMB_RECIPT"), rxs.getString("REIMB_AUTHOR"),
						rxs.getString("REIMB_RESOLVER"), rxs.getDouble("REIMB_STATUS_ID"),
						rxs.getDouble("REIMB_TYPE_ID"), rxs.getString("REIMB_TYPE"), rxs.getString("REIMB_STATUS"));
				users.add(tempa);
				System.out.println(users);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return users;
	}

	public static List<Reimbursement> showReimbursement(String username) {
		List<Reimbursement> users = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT ERS_REIMBURSEMENT.*, ERS_REIMBURSEMENT_TYPE.REIMB_TYPE, ERS_REIMBURSEMENT_STATUS.REIMB_STATUS, ERS_USERS.ERS_USERNAME FROM ERS_REIMBURSEMENT LEFT JOIN ERS_REIMBURSEMENT_STATUS on ERS_REIMBURSEMENT_STATUS.REIMB_STATUS_ID = ERS_REIMBURSEMENT.REIMB_STATUS_ID LEFT JOIN ERS_REIMBURSEMENT_TYPE on ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_ID = ERS_REIMBURSEMENT.REIMB_TYPE_ID LEFT JOIN ERS_USERS on ERS_USERS.ERS_USERS_ID = ERS_REIMBURSEMENT.REIMB_AUTHOR WHERE ERS_USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rxs = ps.executeQuery();
//			ResultSetMetaData rsmd = rxs.getMetaData();
//			int columnsNumber = rsmd.getColumnCount();
			while (rxs.next()) {
				Reimbursement tempa = new Reimbursement(rxs.getString("REIMB_ID"), rxs.getDouble("REIMB_AMOUNT"),
						rxs.getTimestamp("REIMB_SUBMITTED"), rxs.getTimestamp("REIMB_RESOLVED"),
						rxs.getString("REIMB_DESCRIPTION"), rxs.getBytes("REIMB_RECIPT"), rxs.getString("REIMB_AUTHOR"),
						rxs.getString("REIMB_RESOLVER"), rxs.getDouble("REIMB_STATUS_ID"),
						rxs.getDouble("REIMB_TYPE_ID"), rxs.getString("REIMB_TYPE"), rxs.getString("REIMB_STATUS"));
//				System.out.println(user_reimb);
				users.add(tempa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return users;
	}
	/*
	 * public User showReimburment(String username) Reimbursement rxs = null; try
	 * (Connection conn = ConnectionFactory.getInstance().getConnection()) { String
	 * sql =
	 * "SELECT ERS_REIMBURSEMENT.*, ERS_REIMBURSEMENT_TYPE.REIMB_TYPE, ERS_REIMBURSEMENT_STATUS.REIMB_STATUS FROM ERS_REIMBURSEMENT LEFT JOIN ERS_REIMBURSEMENT_STATUS on ERS_REIMBURSEMENT_STATUS.REIMB_STATUS_ID = ERS_REIMBURSEMENT.REIMB_STATUS_ID LEFT JOIN ERS_REIMBURSEMENT_TYPE on ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_ID = ERS_REIMBURSEMENT.REIMB_TYPE_ID WHERE REIMB_AUTHOR = ?"
	 * ; PreparedStatement ps = conn.prepareStatement(sql); ps.setString(1,
	 * username); ResultSet rs = ps.executeQuery(); while (rxs.next()) {
	 * Reimbursement tempa = new Reimbursement(rxs.getDouble("ERS_USERS_ID"),
	 * rxs.getDouble("REIMB_AMOUNT"), rxs.getTimestamp("REIMB_SUBMITTED"),
	 * rxs.getTimestamp("REIMB_RESOLVED"), rxs.getString("REIMB_DESCRIPTION"),
	 * rxs.getBytes("REIMB_RECIPT"), rxs.getDouble("REIMB_AUTHOR"),
	 * rxs.getDouble("REIMB_RESOLVER"), rxs.getDouble("REIMB_STATUS_ID"),
	 * rxs.getDouble("REIMB_TYPE_ID"), rxs.getString("REIMB_TYPE"),
	 * rxs.getString("REIMB_STATUS")); Reimbursement.add(tempa); } } catch
	 * (SQLException e) { e.printStackTrace(); } return users; }}
	 */

	public static Reimbursement Deny(Reimbursement u, User a) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = 00000000000, REIMB_RESOLVER= ?, REIMB_RESOLVED = ? WHERE ERS_REIMBURSEMENT.REIMB_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getUserId());
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			ps.setString(2, myDateObj.format(myFormatObj));
			ps.setString(3, u.getId());
			int numRowsAffected = ps.executeUpdate();
			System.out.print("Denied " + numRowsAffected + " Reimbursement TO DB");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return u;
	}

	public static Reimbursement Approve(Reimbursement u, User a) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = 162145163157154166145, REIMB_RESOLVER= ?, REIMB_RESOLVED = ? WHERE ERS_REIMBURSEMENT.REIMB_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getUserId());
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			ps.setString(2, myDateObj.format(myFormatObj));
			ps.setString(3, u.getId());
			int numRowsAffected = ps.executeUpdate();
			System.out.print("Approved " + numRowsAffected + " Reimbursement TO DB");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return u;
	}

	public static Reimbursement addReimburse(Reimbursement u, User a) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "INSERT INTO ERS_REIMBURSEMENT VALUES (NEWID(),?,?,null,?,null,?,null,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, u.getAmount());
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			ps.setString(2, myDateObj.format(myFormatObj));
			ps.setString(3, u.getDesc());
			ps.setString(4, a.getUserId());
			ps.setDouble(5, 1.65156162145160001486488000e26);
			ps.setDouble(6, u.getTypeId());

			int numRowsAffected = ps.executeUpdate();
			System.out.print("Added " + numRowsAffected + " Reimbursement TO DB");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return u;
	}
}
