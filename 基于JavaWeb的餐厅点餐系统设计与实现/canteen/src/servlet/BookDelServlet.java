package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serviceImpl.BookServiceImpl;

@WebServlet("/del_book")
public class BookDelServlet extends HttpServlet{

private static final long serialVersionUID = -820852300256415161L;
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));

    new BookServiceImpl().del(id);
    
    HttpSession session = request.getSession();
    
    session.setAttribute("msg", "ÏÂ¼Ü³É¹¦");

    
    request.getRequestDispatcher("bookList").forward(request, response);

}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
}
}
