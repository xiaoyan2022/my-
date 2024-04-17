package com.servlet;

import com.dao.CommentDao;
import com.dao.CultureDao;
import com.model.Comment;
import com.model.Culture;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/cultureById")
public class CultureByIdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CultureDao cultureDao = new CultureDao();
		CommentDao commentDao = new CommentDao();
		int cno = Integer.parseInt(req.getParameter("cno"));
		try {
			Culture culture  = cultureDao.queryByCno(cno);
			List<Comment> comments = commentDao.queryByCno(cno);
			HttpSession session = req.getSession();
			session.setAttribute("c",culture);
			session.setAttribute("co",comments);
			req.getRequestDispatcher("cultureById.jsp").forward(req,resp);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
