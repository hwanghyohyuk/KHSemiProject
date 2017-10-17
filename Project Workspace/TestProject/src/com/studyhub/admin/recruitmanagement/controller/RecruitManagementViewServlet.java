package com.studyhub.admin.recruitmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.admin.recruitmanagement.model.service.RecruitManagementService;
import com.studyhub.common.vo.Board;

/**
 * Servlet implementation class RecruitManagementViewServlet
 */
@WebServlet("/recruitmanagementview")
public class RecruitManagementViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RecruitManagementService rms;
	private Board board;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecruitManagementViewServlet() {
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
