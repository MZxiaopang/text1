package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.mytest;
import com.zhiyou.service.UserService;
import com.zhiyou.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = new UserServiceImpl();
		String name = request.getParameter("username") == null ? " " : request.getParameter("username");
		String pass = request.getParameter("password") == null ? " " : request.getParameter("password");
		mytest user = service.SelectByName(request, name, pass);
		if (user == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			response.sendRedirect("show?service=show");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
