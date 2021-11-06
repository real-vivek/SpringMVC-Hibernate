package com.library.management.system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testJDBC")
public class TestJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").println(request.getContextPath());
		String jdbcURL = "jdbc:mysql://localhost:3306/db_name";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Instead of "hbemployee", "hbemployee" you have to use the userName and
			// password that you have created
			Connection connection = DriverManager.getConnection(jdbcURL, "username", "passqord");
			response.getWriter().println("Successfully connected!!");
		} catch (Exception e) {
			response.getWriter().println(e);
		}
	}

}
