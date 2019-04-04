package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.UserDAO;
import com.revature.model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger Log = Logger.getLogger(LoginServlet.class);
	static UserDAO service = new UserDAO();

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
//		HttpSession session = request.getSession();
//		if (session.getAttribute("user") != null) {
//			User u = (User) session.getAttribute("user");
//			response.sendRedirect("users");
//			session.removeAttribute("user");
//			session.invalidate();
//		}
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
		// User inputUser = mapper.readValue(request.getInputStream(), User.class);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// User logged = service.getByRole(inputUser.getUsername());
		// System.out.println(logged);
		// System.out.println(username);
		// System.out.println(password);
		String out = "";
		// service.getUsers();
		Log.info("attempting to log in user -- " + username.toString() + password.toString());
		if (service.Login(username, password)) {
			// writer.write("You have logged in");
			// response.getWriter().write("Logged in Successfully");
			out = (mapper.writeValueAsString(username));
			HttpSession session = request.getSession();
			Log.info("CREATED SESSION " + session.getId() + " AT " + session.getCreationTime());
			session.setAttribute("VALID", true);
			Log.info("Logged in " + username.toString());
			// writer.write("check check");
			// response.sendRedirect("C:\\Users\\SJWL\\Documents\\Eclipse\\hello-servlets\\src\\main\\webapp\\partials\\registration.html");
			if ("Employee".equals(service.getByRole(username).getRole())) {
				User u = service.getByRole(username);
				out = (mapper.writeValueAsString(u));
				Log.info("User is an Employee (E)");
//				response.sendRedirect("http://www.google.com");
//				RequestDispatcher rs = request.getRequestDispatcher("/Employee");
//				rs.forward(request, response);

//				String url = "C:\\Users\\SJWL\\Documents\\Eclipse\\project1\\src\\main\\webapp\\partials\\homepage.html";
//				response.reset();
//				response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
//				response.setHeader("Location", url);
//				response.getWriter().close();
//				response.getWriter().flush();

			} else if ("FM".equals(service.getByRole(username).getRole())) {
				User u = service.getByRole(username);
				out = (mapper.writeValueAsString(u));
				Log.info("User is an Financial Manager (FM)");
				// RequestDispatcher rs = request.getRequestDispatcher("/Fm");
				// rs.forward(request, response);
//			} else {
//				 System.out.println("invalid role");
//				 RequestDispatcher rs = request.getRequestDispatcher("index.html");
//				 rs.include(request, response);
//			}
			} else {
				System.out.println("Invalid Credentials");

				// writer.println("Incorrect Credentials");
				// RequestDispatcher rs = request.getRequestDispatcher("index.html");
				// rs.include(request, response);

			}
			PrintWriter writer = response.getWriter();
			response.setContentType("application/json");
			writer.write(out);
		}
	}
}