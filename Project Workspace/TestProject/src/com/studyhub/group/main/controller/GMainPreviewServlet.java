package com.studyhub.group.main.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studyhub.common.vo.Group;
import com.studyhub.group.main.model.service.GMainService;

/**
 * Servlet implementation class GMainPreviewServlet
 */
@WebServlet("/gmainpreview")
public class GMainPreviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private GMainService gms;
	private Group group;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GMainPreviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int group_no = Integer.parseInt(request.getParameter("group_no"));
		Group group = new GMainService().SelectGroup(group_no);
		
		RequestDispatcher view = null;
		if(group != null){
			HttpSession session = request.getSession();
			session.setAttribute("group",group);
			System.out.println("group session : " + session.getId());
			view = request.getRequestDispatcher("/views/group/GroupMain.jsp");
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
