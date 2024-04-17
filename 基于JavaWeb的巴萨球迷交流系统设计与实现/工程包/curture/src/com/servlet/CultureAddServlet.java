package com.servlet;

import com.dao.CommentDao;
import com.dao.CultureDao;
import com.model.Culture;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;


@WebServlet("/add_culture")
public class CultureAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CultureDao cultureDao = new CultureDao();
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		int open = Integer.parseInt(req.getParameter("open"));
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		Date date = new Date(System.currentTimeMillis());
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		try {
			cultureDao.add(new Culture(title,content,user.getUid(),sqlDate,open));
			req.getRequestDispatcher("cultureListByAuthor").forward(req,resp);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
