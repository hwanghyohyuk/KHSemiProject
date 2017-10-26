package com.studyhub.group.main.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.GNotice;
import com.studyhub.common.vo.Group;
import com.studyhub.common.vo.GBoard;
import com.studyhub.group.main.model.service.GMainService;;

/**
 * Servlet implementation class GBoardPreviewServlet
 */
@WebServlet("/gboardpreview")
public class GBoardPreviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GMainService gms;
	private GBoard gboard;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GBoardPreviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		
		ArrayList<GBoard> list = new GMainService().selectGroupBoard(groupno);
		RequestDispatcher view = request.getRequestDispatcher("/views/group/groupBoard/BoardList.jsp");
		request.setAttribute("list", list);
		view.forward(request, response);
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
