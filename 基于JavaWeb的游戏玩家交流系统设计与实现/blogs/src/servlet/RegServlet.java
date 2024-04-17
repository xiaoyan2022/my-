package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

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
		String nickname = "新用户" + UUID.randomUUID().toString().replace("-", "").substring(0,6);
		UserDao userDao = new UserDao();
		try {
			if(userDao.register(new User(0,username, password, nickname))) {
				req.setAttribute("msg", "注册成功，请登录");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}else {
				req.setAttribute("msg", "注册失败，未知错误");
				req.getRequestDispatcher("reg.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
