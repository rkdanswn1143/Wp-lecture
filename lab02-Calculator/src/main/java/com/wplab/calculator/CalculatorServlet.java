package com.wplab.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/calculate.do")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String op = request.getParameter("operator");
		
		// step #2. data processing
		if (num1 == "")  num1 = "0";
		if (num2 == "")  num2 = "0";
		double num1_ = 0;
		double num2_ = 0;
		try {
			num1_ = Double.parseDouble(num1);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		try {
			num2_ = Double.parseDouble(num2);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		double result = 0;
		
		if ("+".equals(op))  result = num1_ + num2_;
		else if ("-".equals(op))  result = num1_ - num2_;
		else if ("x".equals(op))  result = num1_ * num2_;
		else if ("/".equals(op))  result = num1_ / num2_;
				
		// step #3. output processing results
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Calculator</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>계산 결과</h1>");
		out.println("<hr>");
		if (result - Math.floor(result) > 0)
			out.println(String.format("%s %s %s = %f\n", num1, op, num2, result));
		else 
			out.println(String.format("%s %s %s = %d\n", num1, op, num2, (int)result));
		out.println("<br><br><hr>");
//		out.println("<a href='Calculator.html'><< 계산기 화면</a>");
		out.println("<button onclick='window.location.href=\"Calculator.html\"'><< 계산기 화면</button>");
		out.println("</body>");
		out.println("</html>");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
