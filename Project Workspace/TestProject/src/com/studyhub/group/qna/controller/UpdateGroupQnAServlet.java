package com.studyhub.group.qna.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.group.qna.model.service.GroupQnAService;

/**
 * Servlet implementation class UpdateGroupQnAServlet
 */
@WebServlet("/updategroupqna")
public class UpdateGroupQnAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGroupQnAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int gqnano = Integer.parseInt(request.getParameter("gqnano"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		if(new GroupQnAService().UpdateGroupQnA(gqnano, title, content) > 0) {
			response.sendRedirect("views/group/groupQnA/QnAList.jsp");
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
