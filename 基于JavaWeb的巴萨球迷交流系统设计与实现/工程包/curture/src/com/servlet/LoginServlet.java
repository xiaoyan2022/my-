package com.servlet;

import com.dao.UserDao;
import com.model.User;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		int role = Integer.parseInt(req.getParameter("role"));
		UserDao userDao = new UserDao();
		try {
			if (userDao.checkLogin(username, password)) {
				User user;
				try {
					user = userDao.queryAllByName(username);
					if(user.getRole()!=role){
						req.setAttribute("msg","登录失败，权限不足，请联系管理员");
						req.getRequestDispatcher("login.jsp").forward(req, resp);
					}else{
						HttpSession session = req.getSession();
						session.setAttribute("user", user);
						req.getRequestDispatcher("index.jsp").forward(req, resp);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				req.setAttribute("msg","登录失败，用户名或密码错误");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
