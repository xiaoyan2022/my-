package com.servlet;

import com.dao.TaskDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/taskListByCondition")
public class TaskListByConditionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TaskDao taskDao = new TaskDao();
		HttpSession session = req.getSession();
		String title = req.getParameter("title");
		session.setAttribute("task",taskDao.queryAllByCondition(title));
		req.getRequestDispatcher("task.jsp").forward(req,resp);
	}
}
