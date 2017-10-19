package com.studyhub.group.qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.studyhub.common.vo.Group;
import com.studyhub.common.vo.QnA;
import com.studyhub.group.main.model.service.GMainService;
import com.studyhub.group.qna.model.service.QnAService;

/**
 * Servlet implementation class InsertQnAServlet
 */
@WebServlet("/insertqna")
public class InsertQnAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertQnAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		System.out.println("insertQnA Start ---------");
		
		int userno = Integer.parseInt(request.getParameter("userno"));
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("userno : " + userno +"/ groupno : " + groupno + "/ title : " + title + "/ content : " + content);
		
		
		if(new QnAService().InsertQnA(userno, groupno, title, content) > 0) {
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
