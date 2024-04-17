package com.servlet;

import com.dao.UserDao;
import com.model.User;

import java.io.IOException;
import java.util.UUID;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reg")
public class RegServlet extends HttpServlet{

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
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String nickname = "用户"+str.replace("-", "").substring(0,8);
		UserDao userDao = new UserDao();
		if(userDao.existName(username)){
			req.setAttribute("msg","注册失败，用户名已存在");
			req.getRequestDispatcher("reg.jsp").forward(req, resp);
		}else{
			try {
				if(userDao.register(new User(username, password,nickname,role))) {
					req.setAttribute("msg","注册成功");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}else {
					req.getRequestDispatcher("reg.jsp").forward(req, resp);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
