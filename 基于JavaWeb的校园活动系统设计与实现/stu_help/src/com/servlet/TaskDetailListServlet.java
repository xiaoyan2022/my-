package com.servlet;

import com.dao.TaskDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/taskDetailList")
public class TaskDetailListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TaskDao taskDao = new TaskDao();
		HttpSession session = req.getSession();
		int tid = Integer.parseInt(req.getParameter("tid"));
		session.setAttribute("d",taskDao.queryAllById(tid));
		req.getRequestDispatcher("detail.jsp").forward(req,resp);
	}
}
