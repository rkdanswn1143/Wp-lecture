package com.wp.personalitytest;

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
 * Servlet implementation class Test1Control
 */
@WebServlet("/test3")
public class Test3Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test3Control() {
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
		
		int q3 = Integer.parseInt(request.getParameter("q3"));
		int q4 = Integer.parseInt(request.getParameter("q4"));
		
		// step #2. data processing
		HttpSession session = request.getSession(false);
	
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/start.html");
			return;			
		}
		
		String name = (String)session.getAttribute("name");
		Map<String, Integer> testStore = (Map<String, Integer>)session.getAttribute("test_store");
		testStore.put("q3", q3);
		testStore.put("q4", q4);
		
		// step #3. output results
		request.setAttribute("name", name);
		
		RequestDispatcher view = request.getRequestDispatcher("test3.jsp");
		view.forward(request, response);
	}

}
