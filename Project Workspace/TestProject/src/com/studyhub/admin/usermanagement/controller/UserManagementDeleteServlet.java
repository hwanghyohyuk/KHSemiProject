package com.studyhub.admin.usermanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.admin.usermanagement.model.service.UserManagementService;

/**
 * Servlet implementation class UserManagementDeleteServlet
 */
@WebServlet("/usermanagementdelete")
public class UserManagementDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserManagementService umService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManagementDeleteServlet() {
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
