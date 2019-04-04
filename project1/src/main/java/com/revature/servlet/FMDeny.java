package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.ReimbursementDAO;
import com.revature.data.UserDAO;
import com.revature.model.Reimbursement;

/**
 * Servlet implementation class FMDeny
 */
public class FMDeny extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ReimbursementDAO service = new ReimbursementDAO();
	static UserDAO serve = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FMDeny() {
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
		String param1 = request.getParameter("uid");
		String param2 = request.getParameter("username");
		String out = "";
		Reimbursement a = new Reimbursement(param1);
		out = (mapper.writeValueAsString(ReimbursementDAO.Deny(a, serve.getByRole(param2))));
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		writer.write(out);
	}

}
