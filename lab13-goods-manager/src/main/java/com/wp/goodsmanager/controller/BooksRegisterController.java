package com.wp.goodsmanager.controller;

import java.io.IOException;

import com.wp.goodsmanager.service.DBConnectionInfo;
import com.wp.goodsmanager.service.GoodsDO;
import com.wp.goodsmanager.service.GoodsinfoDAO;
import com.wp.goodsmanager.service.GoodsinfoDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BooksRegisterController
 */
//@WebServlet("/books/register")
public class BooksRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");
		
		GoodsDO goods = new GoodsDO();
		goods.setCode(request.getParameter("code"));
		goods.setTitle(request.getParameter("title"));
		goods.setWriter(request.getParameter("writer"));
		String priceStr = request.getParameter("price");
		goods.setPrice((priceStr != null && !priceStr.isEmpty()) ? Integer.parseInt(priceStr) : 0);
		
		// step #2. process business logic
		DBConnectionInfo dbInfo = (DBConnectionInfo)getServletContext().getAttribute("db_info");
		GoodsinfoDAO dao = new GoodsinfoDAOImpl(dbInfo);
		dao.insertGoods(goods);
			
		// step #3. output results to the client
		response.sendRedirect("list");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
