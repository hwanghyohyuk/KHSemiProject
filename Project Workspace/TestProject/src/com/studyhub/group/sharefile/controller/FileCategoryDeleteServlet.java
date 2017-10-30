package com.studyhub.group.sharefile.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.group.qna.model.service.GroupQnAService;
import com.studyhub.group.sharefile.model.service.ShareFileService;

/**
 * Servlet implementation class FileCategoryDeleteServlet
 */
@WebServlet("/filecategorydelete")
public class FileCategoryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileCategoryDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("cno"));
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		
		if(new ShareFileService().deleteCategory(cno) > 0){
			response.sendRedirect("/studyhub/sharedfilepreview?groupno="+groupno);
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
