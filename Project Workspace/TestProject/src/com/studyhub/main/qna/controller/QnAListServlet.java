package com.studyhub.main.qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.QnA;
import com.studyhub.main.qna.model.service.QnAService;

/**
 * Servlet implementation class QnAListServlet
 */
@WebServlet("/qnalist")
public class QnAListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QnAService qs;
	private QnA qna;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		ArrayList<QnA> list = new QnAService().selectList();
		RequestDispatcher view = null;
		if(list!=null){
			view= request.getRequestDispatcher("/views/main/QnA/QnAList.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("/views/main/QnA/QnAError.jsp");
			request.setAttribute("message", "리스트 불러오기 실패");
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
