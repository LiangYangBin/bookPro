package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import entity.Book;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/delBook")
public class delBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookDao bookDao = new BookDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("bid");
		try {
			bookDao.delBook(bid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.getRequestDispatcher("admin").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
