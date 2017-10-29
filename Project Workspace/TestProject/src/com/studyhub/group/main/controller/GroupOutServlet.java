package com.studyhub.group.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.group.main.model.service.GMainService;

/**
 * Servlet implementation class GroupOutServlet
 */
@WebServlet("/groupout")
public class GroupOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int userno = Integer.parseInt(request.getParameter("userno"));
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		int authorityno = Integer.parseInt(request.getParameter("authorityno"));
		
		if(authorityno == 2) {
			// 그룹 해제
		} else {
			if(new GMainService().GroupOut(userno, groupno) > 0)
				response.sendRedirect("views/main/main.jsp");
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
