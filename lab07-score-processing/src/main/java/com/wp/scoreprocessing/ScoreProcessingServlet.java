package com.wp.scoreprocessing;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScoreProcessingServlet
 */
@WebServlet("/process-score.do")
public class ScoreProcessingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreProcessingServlet() {
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
		String[] scores = request.getParameterValues("scores");
		
		// step #2. data processing
		// business logic
		ScoreDO scoreDO = new ScoreDO();
		scoreDO.setScores(scores);
		ScoreProcessingService.process(scoreDO);

		// step #3. output processing results
		// presentation logic
		request.setAttribute("score_data", scoreDO);
		
		RequestDispatcher view = request.getRequestDispatcher("output-score.do");
		view.forward(request, response);
	}

}
