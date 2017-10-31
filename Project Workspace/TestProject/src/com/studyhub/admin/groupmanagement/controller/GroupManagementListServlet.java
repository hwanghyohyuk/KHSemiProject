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
import com.studyhub.admin.usermanagement.model.service.UserManagementService;
import com.studyhub.common.vo.Group;
import com.studyhub.common.vo.User;

/**
 * Servlet implementation class GroupManagementListServlet
 */
@WebServlet("/groupmanagementlist")
public class GroupManagementListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GroupManagementService gms;
	private Group group;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupManagementListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); 
		RequestDispatcher view = null;
		
		ArrayList<Group> list = new GroupManagementService().groupList();
		
		if(list!=null){
			view= request.getRequestDispatcher("/views/admin/GroupManagement.jsp");
			request.setAttribute("glist", list);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("/views/main/QnA/QnAError.jsp");
			request.setAttribute("message", "view 출력 실패");
			view.forward(request, response);
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
