package com.wp.favoritelist;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class GetColorServlet
 */
@WebServlet("/get_color.do")
public class GetColorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetColorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");
		String food = request.getParameter("food");
		
		// step #2. data processing
		boolean isAllowedAccess = true;
		HttpSession session = request.getSession(false);
		if (session == null) {
			isAllowedAccess = false;
		}
		else {
			Map<String, String> favoriteList = 
				(Map<String, String>)session.getAttribute("favorite_list");
			favoriteList.put("음식", food);
		}
		
		// step #3. output results
		if (isAllowedAccess) {
			request.setAttribute("userid", session.getAttribute("userid"));
			
			RequestDispatcher view = request.getRequestDispatcher("get_color.jsp");
			view.forward(request, response);
		}
		else {
			response.sendRedirect("login.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
