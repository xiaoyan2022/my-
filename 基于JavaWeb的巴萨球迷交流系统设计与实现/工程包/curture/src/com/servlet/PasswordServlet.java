package com.servlet;

import com.dao.UserDao;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/password")
public class PasswordServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		User user = (User)req.getSession().getAttribute("user");
		String oldPass = req.getParameter("oldPass");
		String newPass = req.getParameter("newPass");
		UserDao userDao = new UserDao();
		try {
			if(!userDao.checkLogin(user.getUsername(),oldPass)){
				req.setAttribute("msg","原密码错误");
			}else{
				user.setPassword(newPass);
				userDao.updatePassword(user);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		req.getRequestDispatcher("login.jsp").forward(req,resp);
	}
}
