package com.servlet;

import com.dao.TaskDao;
import com.dao.UserDao;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/taskList")
public class TaskListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TaskDao taskDao = new TaskDao();
		HttpSession session = req.getSession();
		session.setAttribute("task",taskDao.queryAll());
		req.getRequestDispatcher("task.jsp").forward(req,resp);
	}
}
