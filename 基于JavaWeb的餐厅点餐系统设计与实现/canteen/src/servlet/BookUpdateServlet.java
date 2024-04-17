package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import serviceImpl.BookServiceImpl;

@WebServlet("/update_book")
public class BookUpdateServlet extends HttpServlet{

private static final long serialVersionUID = -820852300256415161L;
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String author = request.getParameter("author");
    String publish = request.getParameter("publish");
    Float price = Float.valueOf(request.getParameter("price"));

    new BookServiceImpl().update(new Book(id, name, author, publish, price));
    
    HttpSession session = request.getSession();
    
    session.setAttribute("msg", "ÐÞ¸Ä³É¹¦");
    
    request.getRequestDispatcher("bookList").forward(request, response);

}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
}
}
