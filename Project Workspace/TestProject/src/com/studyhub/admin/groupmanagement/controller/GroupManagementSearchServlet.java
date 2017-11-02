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
 * Servlet implementation class GroupManagementSearchServlet
 */
@WebServlet("/groupmanagementsearch")
public class GroupManagementSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
		private GroupManagementService gms;
		private Group group;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupManagementSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String searchby = request.getParameter("search-by");
		String keyword = request.getParameter("keyword");
		ArrayList<Group> list = null;
		System.out.println(searchby+"::"+keyword);
		if(searchby.equals("group_name")){
			list = new GroupManagementService().groupNameSearch(keyword);
		}else{
			list = new GroupManagementService().CategorySearch(keyword);
		}
		System.out.println(list);
		RequestDispatcher view = null;
		if (list != null) {
			view = request.getRequestDispatcher("/views/admin/GroupManagement.jsp");
			request.setAttribute("glist", list);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/main/QnA/QnAError.jsp");
			request.setAttribute("message", "검색 실패");
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
