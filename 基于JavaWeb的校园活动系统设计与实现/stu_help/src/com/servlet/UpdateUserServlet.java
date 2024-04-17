package com.servlet;

import com.dao.UserDao;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update_user")
public class UpdateUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		User user = (User)req.getSession().getAttribute("user");
		UserDao userDao = new UserDao();
		int sno = user.getSno();
		String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		String college = req.getParameter("college");
		userDao.updateUser(new User(sno,name,sex,college));
		req.getRequestDispatcher("userList").forward(req,resp);
	}
}
