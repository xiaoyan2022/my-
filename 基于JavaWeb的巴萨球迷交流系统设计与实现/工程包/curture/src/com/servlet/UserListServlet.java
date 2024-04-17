package com.servlet;

import com.dao.UserDao;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/userList")
public class UserListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User)req.getSession().getAttribute("user");
		HttpSession session = req.getSession();
		UserDao userDao = new UserDao();
		session.setAttribute("user",userDao.queryAllByName(user.getUsername()));
		req.getRequestDispatcher("user.jsp").forward(req,resp);
	}
}
