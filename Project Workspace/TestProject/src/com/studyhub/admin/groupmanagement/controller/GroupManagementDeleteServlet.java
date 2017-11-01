package com.studyhub.admin.groupmanagement.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.admin.groupmanagement.model.service.GroupManagementService;
import com.studyhub.common.vo.Group;

/**
 * Servlet implementation class GroupManagementDeleteServlet
 */
@WebServlet("/groupmanagementdelete")
public class GroupManagementDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GroupManagementService gms;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupManagementDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8"); 
		
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		int userno = Integer.parseInt(request.getParameter("userno"));
		
		if(new GroupManagementService().groupDelete(groupno) > 0 ){
			if(new GroupManagementService().groupMessage(groupno, userno) > 0 ){
				response.sendRedirect("/studyhub/groupmanagementlist");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
