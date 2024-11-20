package com.wplab.helloworld;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class IntervalSumServlet
 */
@WebServlet("/intervalsum")
public class IntervalSumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntervalSumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		String startStr = request.getParameter("start");
		String endStr = request.getParameter("end");
		
		int startNum = 1;
		if (startStr != null && !startStr.isBlank()) {
			startNum = Integer.parseInt(startStr);
		}
		
		int endNum = 100;
		if (endStr != null && !endStr.isBlank()) {
			endNum = Integer.parseInt(endStr);
		}
			
		// step #2. data processing
		long sum = 0;
		for (int i=startNum; i<=endNum; i++) {
			sum += i;
		}
		
		// step #3. output results
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>구간 합</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>구간 합 구하기</h1><hr>");
		out.println("<p>" + startNum + "에서 " + endNum + "까지 구간 합 = " + sum + "</p>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
