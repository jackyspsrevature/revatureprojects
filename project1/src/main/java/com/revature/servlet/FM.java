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
 * Servlet implementation class FM
 */
public class FM extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger Log = Logger.getLogger(Employee.class);
	static ReimbursementDAO service = new ReimbursementDAO();
	static UserDAO serve = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FM() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		ObjectMapper mapper = new ObjectMapper();
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		Log.info(service.getReimbursement());
		String out = "";
		out = (mapper.writeValueAsString(service.getReimbursement()));
		Log.info(out);
		writer.write(out);
//		service.resolved();
//		service.unresolved();

//		service.showReimbursement(request.getParameter("username"));
//
//		String optiontwo = request.getParameter("New_request");
//		double setAmount = Double.parseDouble(request.getParameter("amount"));
//		String desc = request.getParameter("desc");
//		double TypeId = Double.parseDouble(request.getParameter("TypeID"));

	}

}
