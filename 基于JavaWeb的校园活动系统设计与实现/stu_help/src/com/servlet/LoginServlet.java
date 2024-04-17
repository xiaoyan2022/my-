package com.servlet;

import com.dao.GoodDao;
import com.dao.TaskDao;
import com.dao.UserDao;
import com.model.Task;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int sno = Integer.parseInt(req.getParameter("sno"));
		String pwd = req.getParameter("pwd");
		UserDao userDao = new UserDao();
		TaskDao taskDao = new TaskDao();
		GoodDao goodDao = new GoodDao();
		try {
			if (userDao.checkLogin(sno, pwd)) {
				User user;
				try {
					user = userDao.queryAllBySno(sno);
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
					session.setAttribute("count",taskDao.count(sno,1));
					session.setAttribute("count2",taskDao.count(sno,0));
					session.setAttribute("count3",goodDao.count(sno,1));
					session.setAttribute("count4",goodDao.count(sno,0));
					session.setAttribute("colleges",userDao.collegeList());
					req.getRequestDispatcher("userList").forward(req, resp);
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
