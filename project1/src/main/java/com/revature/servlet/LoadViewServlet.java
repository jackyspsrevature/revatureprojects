package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("*.view")
public class LoadViewServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(LoadViewServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		log.info("REQUEST SENT TO URI: " + req.getRequestURI());
		String uri = req.getRequestURI();

		String name = uri.substring(10, (uri.length() - 5));
		log.info("TESTING URI " + name);
		req.getRequestDispatcher("partials/" + name + ".html").forward(req, resp);

	}

	private String getResource(String uri) {
		String resource = "partials/";
		switch (uri) {
		case "/project1/landing.view":
			resource += "landing.html";
			break;

		case "/project1/home.view":
			resource += "homepage.html";
			break;

		case "/project1/Employee.view":
			resource += "Employee.html";
			break;

		case "/project1/FM.view":
			resource += "FM.html";
			break;

		}
		return resource;
	}
}
