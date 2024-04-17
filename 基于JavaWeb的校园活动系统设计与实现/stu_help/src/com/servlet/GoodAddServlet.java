package com.servlet;

import com.dao.GoodDao;
import com.dao.TaskDao;
import com.model.Good;
import com.model.Task;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;


@WebServlet("/add_good")
public class GoodAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		GoodDao goodDao = new GoodDao();
		String name = req.getParameter("name");
		String des = req.getParameter("des");
		HttpSession session = req.getSession();
		User user = (User)req.getSession().getAttribute("user");
		java.util.Date date = new java.util.Date(System.currentTimeMillis());
		Date sqlDate = new Date(date.getTime());
		try {
			goodDao.add(new Good(user.getSno(),name,des,sqlDate));
			session.setAttribute("count3",goodDao.count(user.getSno(),1));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		req.getRequestDispatcher("goodListBySno?status=1").forward(req,resp);
	}
}
