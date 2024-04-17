package com.servlet;

import com.dao.CommentDao;
import com.model.Comment;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet("/add_comment")
public class CommentAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		int cno = Integer.parseInt(req.getParameter("cno"));
		String content = req.getParameter("content");
		User user = (User)req.getSession().getAttribute("user");
		Date date = new Date(System.currentTimeMillis());
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		CommentDao commentDao = new CommentDao();
		try {
			commentDao.add(new Comment(cno,user.getUid(),content,sqlDate));
			req.getRequestDispatcher("cultureById?cno="+cno).forward(req,resp);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
