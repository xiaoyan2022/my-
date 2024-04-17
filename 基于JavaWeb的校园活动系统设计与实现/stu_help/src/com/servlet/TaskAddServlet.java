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
import java.text.SimpleDateFormat;


@WebServlet("/add_task")
public class TaskAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		TaskDao taskDao = new TaskDao();
		String title = req.getParameter("title");
		String des = req.getParameter("des");
		int reward = Integer.parseInt(req.getParameter("reward"));
		HttpSession session = req.getSession();
		User user = (User)req.getSession().getAttribute("user");
		String timeStr = req.getParameter("time");
		java.sql.Date time = Date.valueOf(timeStr);
		String endStr = req.getParameter("end");
		java.sql.Date end = Date.valueOf(endStr);
		try {
			taskDao.add(new Task(user.getSno(),title,des,time,reward,end));
			session.setAttribute("count",taskDao.count(user.getSno(),1));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		req.getRequestDispatcher("taskListBySno?status=1").forward(req,resp);
	}
}
