package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.NEW;

import daoImpl.UserDaoImpl;
import model.Book;
import model.User;
import serviceImpl.BookServiceImpl;
import serviceImpl.UserServiceImpl;

@WebServlet("/update_user")
public class UserUpdateServlet extends HttpServlet{

private static final long serialVersionUID = -820852300256415161L;
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	String nickname = request.getParameter("nickname");
	String address = request.getParameter("address");
	String tel = request.getParameter("tel");
	HttpSession session = request.getSession();
	User user = (User)session.getAttribute("user");
	
    new UserDaoImpl().update(new User(user.getId(), nickname, address, tel));
        
    session.setAttribute("adName", new UserServiceImpl().queryByName(user.getUsername()).getNickname());
    
    session.setAttribute("user", new UserServiceImpl().queryByName(user.getUsername()));
    
    session.setAttribute("msg", "ÐÞ¸Ä³É¹¦");
    
    request.getRequestDispatcher("update_user.jsp").forward(request, response);

}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
}
}
