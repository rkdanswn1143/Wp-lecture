package com.wp.favoritelist;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IntervalSumServlet
 */
@WebServlet("/intervalsum.do")
public class IntervalSumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntervalSumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	private int getIntervalSum(int start, int end) {
		int sum = 0;
		for (int i=start; i<=end; i++) {
			sum += i;
		}
		return sum;
	}    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		String start_ = request.getParameter("start");
		String end_ = request.getParameter("end");
		
		// step #2. data processing(business logic)
		int start = 0;
		if (start_ != null) {
			start = Integer.parseInt(start_);
		}
		int end = 0;
		if (end_ != null) {
			end = Integer.parseInt(end_);
		}
		
		int sum = getIntervalSum(start, end);
		
		// step #3. output processing results(presentation logic)
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("sum", sum);
		
		RequestDispatcher view = request.getRequestDispatcher("/interval_sum.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
