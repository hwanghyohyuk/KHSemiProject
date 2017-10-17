package com.studyhub.group.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.GBoard;
import com.studyhub.group.board.model.service.GBoardService;

/**
 * Servlet implementation class GBoardInsertServlet 
 */
@WebServlet("/gboardinsert")
public class GBoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GBoard gNboard;
	private GBoardService gNboardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GBoardInsertServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
