package com.servlet;

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


@WebServlet("/update_culture")
public class CultureUpdate extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CultureDao cultureDao = new CultureDao();
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		int cno = Integer.parseInt(req.getParameter("cno"));
		int open = Integer.parseInt(req.getParameter("open"));

		System.out.println(open);

		try {
			cultureDao.updateByCno(new Culture(title,content,cno,open));
			req.getRequestDispatcher("cultureListByAuthor").forward(req,resp);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
