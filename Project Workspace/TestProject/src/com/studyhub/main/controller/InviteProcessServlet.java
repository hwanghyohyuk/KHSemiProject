package com.studyhub.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.main.model.service.MainService;

/**
 * Servlet implementation class InviteProcessServlet
 */
@WebServlet("/inviteprocess")
public class InviteProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InviteProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int messageno = Integer.parseInt(request.getParameter("messageno"));
		int receiver = Integer.parseInt(request.getParameter("receiver"));
		int sender = Integer.parseInt(request.getParameter("sender"));
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		int state = Integer.parseInt(request.getParameter("state"));
		
		if(state == 1) { // 초대수락(ung 인서트, 메시지상태2, 메시지인서트)
			if(new MainService().InviteAgree(groupno, receiver) > 0) {
				if(new MainService().changeMessage1(messageno) > 0) {
					if(new MainService().InsertMessage(groupno, sender, receiver) > 0) {
						response.sendRedirect("views/include/main/header.jsp");
					}
				}
			}
		} else if(state == 0) { // 초대거절 (메시지 상태2, 메시지 인서트)
			if(new MainService().changeMessage1(messageno) > 0) {
				if(new MainService().InsertMessage2(groupno, sender, receiver) > 0)
					response.sendRedirect("views/include/main/header.jsp");
			}
		} else {
			if(new MainService().changeMessage1(messageno) > 0) {
				response.sendRedirect("views/include/main/header.jsp");
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
