package com.studyhub.group.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.group.main.model.service.GMainService;

/**
 * Servlet implementation class UserManageServlet
 */
@WebServlet("/usermanage")
public class UserManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int ungno = Integer.parseInt(request.getParameter("ungno"));
		int state = Integer.parseInt(request.getParameter("state"));
		
		if(state == 1){ // 가입승인 ung_state 1로
			if(new GMainService().InviteGroup(ungno) > 0){
				response.sendRedirect("views/group/GroupMain.jsp");
			}
		} else if(state == 2){ // 가입거절 delete ung
			if(new GMainService().RemoveUser(ungno) > 0){
				response.sendRedirect("views/group/GroupMain.jsp");
			}
		} else if(state == 3){ // 회원 추방 update ung_state 2로
			if(new GMainService().OutUser(ungno) > 0 ){
				response.sendRedirect("views/group/GroupMain.jsp");
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
