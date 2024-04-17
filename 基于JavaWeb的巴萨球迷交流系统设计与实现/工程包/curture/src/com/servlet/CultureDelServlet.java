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


@WebServlet("/del_culture")
public class CultureDelServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CultureDao cultureDao = new CultureDao();
		int cno = Integer.parseInt(req.getParameter("cno"));
		try {
			cultureDao.delByCno(cno);
			req.getRequestDispatcher("cultureListByAuthor").forward(req,resp);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
