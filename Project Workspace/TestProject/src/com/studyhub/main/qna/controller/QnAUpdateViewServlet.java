package com.studyhub.main.qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.QnA;
import com.studyhub.main.qna.model.service.QnAService;

/**
 * Servlet implementation class QnAUpdateViewServlet
 */
@WebServlet("/qnaupdateview")
public class QnAUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QnAService qs;
	private QnA qna;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAUpdateViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		QnA qna = new QnAService().selectQNA(Integer.parseInt(request.getParameter("no")));
		
		RequestDispatcher view = null;
		
		if(qna !=null){
			view = request.getRequestDispatcher("/views/main/QnA/QnAUpdateForm.jsp");
			request.setAttribute("qna", qna);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("/views/main/QnA/QnAError.jsp");
			request.setAttribute("message","수정화면 출력 실패");
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
