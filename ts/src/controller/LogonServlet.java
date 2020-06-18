package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/Logon")
public class LogonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDao userDao = new UserDao();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uphone = request.getParameter("phone");
		String upassword = request.getParameter("password");
		String remember = request.getParameter("remember");
		Cookie[] cookie = request.getCookies();
		boolean lock = false;
		String phone = null;
		String pwd = null;
		User user = userDao.logon(uphone,upassword);
		HttpSession session = request.getSession();
		
		
		if(cookie != null && cookie.length > 0) {
			for(Cookie c : cookie) {
				if(c.getName().equals("phone")) {
					phone = c.getValue();
				}
				if(c.getName().equals("password")) {
					pwd = c.getValue();
				}
			}
		}
		
		if(phone != null && pwd != null) {
			lock = true;
		}
		
		if(!lock) {
			if(user != null) {
				if(remember != null && remember.equals("1")) {
					Cookie uphoneCookie = new Cookie("uphone",uphone);
					Cookie upasswordCookie = new Cookie("upassword",upassword);
					uphoneCookie.setMaxAge(60*60*24);
					upasswordCookie.setMaxAge(60*60*24);
					response.addCookie(uphoneCookie);
					response.addCookie(upasswordCookie);
				}
				session.setAttribute("user", user.getUname());
				request.getRequestDispatcher("admin").forward(request, response);
			}else {
				request.setAttribute("msg", "ÃÜÂë´íÎó£¬ÇëÖØÐÂµÇÂ¼");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else {
			response.sendRedirect("admin");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
