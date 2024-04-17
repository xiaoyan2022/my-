package com.servlet;

import com.dao.GoodDao;
import com.dao.TaskDao;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/del_good")
public class GoodDelServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int gid = Integer.parseInt(req.getParameter("gid"));
		GoodDao goodDao = new GoodDao();
		User user = (User)req.getSession().getAttribute("user");
		HttpSession session = req.getSession();
		try {
			goodDao.del(gid);
			session.setAttribute("count3",goodDao.count(user.getSno(),1));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		req.getRequestDispatcher("goodListBySno?status=1").forward(req,resp);
	}
}
