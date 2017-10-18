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
		
		int userno = Integer.parseInt(request.getParameter("userno"));
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		if(new QnAService().InsertQnA(userno, groupno, title, content) > 0) {
			Group group = new GMainService().SelectGroup(groupno);
			
			RequestDispatcher view = null;
			if(group != null){
				view = request.getRequestDispatcher("views/group/groupQnA/QnAList.jsp");
				request.setAttribute("group", group);
				view.forward(request, response);
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
