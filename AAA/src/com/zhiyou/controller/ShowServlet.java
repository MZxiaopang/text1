package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.mytest;
import com.zhiyou.service.UserService;
import com.zhiyou.service.impl.UserServiceImpl;

public class ShowServlet extends HttpServlet {

	UserService service = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String string = request.getParameter("service");
		System.out.println(string);
		if (string.equals("show")) {
			show(request, response);
		}
		if (string.equals("delete")) {
			delete(request, response);
		}
		if (string.equals("add")) {
			add(request, response);
		}
		if (string.equals("update")) {
			update(request, response);
		}
		if (string.equals("alter")) {
			alter(request, response);
		}

	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count = service.selectCount();
		int page = request.getParameter("page") == null || request.getParameter("page") == "" ? 1
				: Integer.valueOf(request.getParameter("page"));
		request.setAttribute("count", count);
		request.setAttribute("list", service.SelectMessage((page - 1) * 5, 5));
		request.getRequestDispatcher("/WEB-INF/jsp/show.jsp").forward(request, response);
	}

	private void alter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String sex = request.getParameter("sex");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if (id == null) {
			mytest mytest = new mytest(sex, name, password);
			service.AddMessage(mytest);
		} else {
			mytest mytest = new mytest(Integer.valueOf(id), sex, name, password);
			service.UpdateMessage(mytest);
		}
		response.sendRedirect("show?service=show");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		mytest mytest = service.SelectById(Integer.valueOf(request.getParameter("id")));
		request.setAttribute("user", mytest);
		request.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String string = request.getParameter("id");
		service.DeleteMessage(Integer.valueOf(string));
		response.sendRedirect("show?service=show");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
