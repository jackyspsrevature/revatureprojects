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
import com.revature.model.Reimbursement;

/**
 * Servlet implementation class EmployeeAdd
 */
public class EmployeeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger Log = Logger.getLogger(Employee.class);
	static ReimbursementDAO service = new ReimbursementDAO();
	static UserDAO serve = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeAdd() {
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
		String param1 = request.getParameter("username");
		String out = "";
		double setAmount = Double.parseDouble(request.getParameter("amount"));
		String desc = request.getParameter("desc");
		double TypeId = Double.parseDouble(request.getParameter("TypeID"));
		Log.info(serve.getByRole(param1).getUserId());
		Reimbursement a = new Reimbursement(setAmount, desc, serve.getByRole(param1).getUserId(), TypeId);
		// Log.info(ReimbursementDAO.addReimburse(a, serve.getByRole(param1)));
		out = (mapper.writeValueAsString(ReimbursementDAO.addReimburse(a, serve.getByRole(param1))));
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		writer.write(out);
	}

}
