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


@WebServlet("/del_comment")
public class CommentDelServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		int cid = Integer.parseInt(req.getParameter("cid"));
		int cno = Integer.parseInt(req.getParameter("cno"));
		CommentDao commentDao = new CommentDao();
		try {
			commentDao.delByCid(cid);
			req.getRequestDispatcher("cultureById?cno="+cno).forward(req,resp);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
