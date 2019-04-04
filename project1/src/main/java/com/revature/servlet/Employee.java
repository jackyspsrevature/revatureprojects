package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.ReimbursementDAO;
import com.revature.data.UserDAO;

/**
 * Servlet implementation class Employee
 */
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger Log = Logger.getLogger(Employee.class);
	static ReimbursementDAO service = new ReimbursementDAO();
	static UserDAO serve = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		ObjectMapper mapper = new ObjectMapper();
		String param1 = req.getParameter("username");
		String out = "";
//		String option = req.getParameter("View_past_tickets");
		Log.info(param1);
		Log.info(serve.getByRole(param1).getUserId());
//		service.showReimbursement(param1);
		Log.info(service.showReimbursement(param1));
		service.showReimbursement(param1);
		// List<Reimbursement> u = service.showReimbursement(param1);
		out = (mapper.writeValueAsString(service.showReimbursement(param1)));
		Log.info(out);
		PrintWriter writer = res.getWriter();
		res.setContentType("application/json");
		writer.write(out);

		// String optiontwo = req.getParameter("New_request");
//		double setAmount = Double.parseDouble(req.getParameter("amount"));
//		String desc = req.getParameter("desc");
//		double TypeId = Double.parseDouble(req.getParameter("TypeID"));
//		Reimbursement a = new Reimbursement(setAmount, desc, Userid, TypeId);
//		ReimbursementDAO.addReimburse(a, serve.getByRole(param1));

		// handleRequest(req, res);

	}

	/*
	 * public void handleRequest(HttpServletRequest req, HttpServletResponse resp)
	 * throws IOException, ServletException {
	 * 
	 * resp.setContentType("text/html");
	 * 
	 * // Post Parameters From The Request String param1 =
	 * req.getParameter("username");
	 * 
	 * // Building & Printing The HTML Response Code PrintWriter out =
	 * resp.getWriter(); out.
	 * write("<html><body><div id='serlvetResponse' style='text-align: center;'>");
	 * out.write("<h2>Servlet Dispatcher</h2>"); out.write(
	 * "<p style='color: green; font-size: large;'>You are authorized! <span style='text-transform: capitalize;'>"
	 * + param1 + "</span>, You are an authorised login!</p>");
	 * out.write("</div></body></html>"); out.close(); }
	 */
}
