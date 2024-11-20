package com.wp.personalitytest;

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
 * Servlet implementation class Test1Control
 */
@WebServlet("/test1")
public class Test1Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1Control() {
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
		
		String name = request.getParameter("name");
		
		// step #2. data processing
		HttpSession session = request.getSession();
		
		if (session.isNew()) {
			session.setAttribute("name", name);
			session.setAttribute("test_store", new HashMap<String, Integer>());		
		}
		else {
			String savedName = (String)session.getAttribute("name");
			if (savedName == null) {
				session.invalidate();
				response.sendRedirect(request.getContextPath() + "/start.html");
				return;
			}
			else if (!savedName.equals(name)) {
				session.setAttribute("name", name);
			}
		}
		
		// step #3. output results
		request.setAttribute("name", name);
		
		RequestDispatcher view = request.getRequestDispatcher("test1.jsp");
		view.forward(request, response);
	}

}
