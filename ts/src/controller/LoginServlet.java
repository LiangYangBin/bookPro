package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String uphone = request.getParameter("phone");
		String upassword1 = request.getParameter("password1");
		String upassword2 = request.getParameter("password2");
		System.out.println(username);
		System.out.println(uphone);
		System.out.println(upassword1);
		System.out.println(upassword2);
		if(upassword1.equals(upassword2)) {
			try {
				userDao.login(username,uphone,upassword1);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("msg", "注册成功");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "两次密码不一致");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
