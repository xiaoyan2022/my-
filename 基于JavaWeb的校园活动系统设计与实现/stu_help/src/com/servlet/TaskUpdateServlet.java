package com.servlet;

import com.dao.TaskDao;
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


@WebServlet("/update_task")
public class TaskUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TaskDao taskDao = new TaskDao();
		int tid = Integer.parseInt(req.getParameter("tid"));
		User user = (User)req.getSession().getAttribute("user");
		HttpSession session = req.getSession();
		try {
			taskDao.update(user.getSno(),tid);
			session.setAttribute("count2",taskDao.count(user.getSno(),0));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		req.getRequestDispatcher("taskListBySno?status=0").forward(req,resp);
	}
}
