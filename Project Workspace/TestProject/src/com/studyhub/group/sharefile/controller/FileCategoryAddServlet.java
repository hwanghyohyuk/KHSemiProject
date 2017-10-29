package com.studyhub.group.sharefile.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.group.sharefile.model.service.ShareFileService;

/**
 * Servlet implementation class FileCategoryAddServlet
 */
@WebServlet("/filecategoryadd")
public class FileCategoryAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileCategoryAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		RequestDispatcher view = null;
		
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		String cname = request.getParameter("cname");
		
		if(new ShareFileService().addCategory(groupno, cname) >0 ){
			response.sendRedirect("/studyhub/sharedfilepreview?groupno="+groupno);
		}else{
			view= request.getRequestDispatcher("views/group/groupFileShare/fileshareError.jsp");
			request.setAttribute("message", "카테고리 추가 실패!");
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
