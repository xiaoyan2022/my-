package com.servlet;

import com.dao.UserDao;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@WebServlet("/reg")
public class RegServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int sno = Integer.parseInt(req.getParameter("sno"));
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		int sex = Integer.parseInt(req.getParameter("sex"));
		String college = req.getParameter("college");
		java.util.Date date = new java.util.Date(System.currentTimeMillis());
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		UserDao userDao = new UserDao();
		if(userDao.exist(sno)){
			req.setAttribute("msg","注册失败，学号已存在");
			req.getRequestDispatcher("reg.jsp").forward(req, resp);
		}
		try {
			if(userDao.register(new User(sno,pwd,name,sex==1?"男":"女",college,sqlDate))) {
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
