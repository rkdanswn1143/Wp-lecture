package com.wp.favoritelist;

import java.io.IOException;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
	name = "login_servlet",
	urlPatterns = {"/login.do"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		// step #2. data processing
		// - member authentication
		boolean isAuthenticated = false;
		
		if (userid != null && password != null) {
			if (userid.equals("gdhong") && password.equals("1234")) {
				HttpSession session = request.getSession();
				session.setAttribute("userid", userid);
				session.setAttribute("favorite_list", new HashMap<String, String>());
				isAuthenticated = true;
			}
		}
		
		// step #3. output processing results
		if (isAuthenticated) {
			request.setAttribute("userid", userid);
			
			RequestDispatcher view = request.getRequestDispatcher("get_food.jsp");
			view.forward(request, response);
		}
		else {
			response.sendRedirect(request.getHeader("Referer"));
		}
	}
}
