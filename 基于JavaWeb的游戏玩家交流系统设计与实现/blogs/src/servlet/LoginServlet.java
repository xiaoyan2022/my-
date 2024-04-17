package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserDao userDao = new UserDao();
		if (userDao.checkLogin(username, password)) {
			User user;
			try {
				user = userDao.queryAllByName(username);
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				req.getRequestDispatcher("blogList").forward(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			req.setAttribute("msg", "登录失败，用户名或密码错误");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
