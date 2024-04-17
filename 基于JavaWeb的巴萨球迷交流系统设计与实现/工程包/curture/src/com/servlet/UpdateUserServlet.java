package com.servlet;

import com.dao.UserDao;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		User user = (User)req.getSession().getAttribute("user");
		String nickname = req.getParameter("nickname");
		UserDao userDao = new UserDao();
		if(userDao.exist(nickname) && !user.getNickname().equals(nickname)){
			req.setAttribute("msg","昵称"+nickname+"已存在");
		}
		try {
			userDao.update(new User(user.getUid(),nickname));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		req.getRequestDispatcher("userList").forward(req,resp);
	}
}
