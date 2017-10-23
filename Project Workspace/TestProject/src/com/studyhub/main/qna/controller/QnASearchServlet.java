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
 * Servlet implementation class QnASearchServlet
 */
@WebServlet("/qnasearch")
public class QnASearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnASearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String searchby = request.getParameter("search-by");
		String keyword = request.getParameter("keyword");
		if (searchby.equals("title")) {

			ArrayList<QnA> list = new QnAService().selectTitleSearch(keyword);
			RequestDispatcher view = null;
			if (list != null) {
				view = request.getRequestDispatcher("views/main/QnA/QnAList.jsp");
				request.setAttribute("list", list);
				view.forward(request, response);
			} else {
				view = request.getRequestDispatcher("views/main/QnA/QnAError.jsp");
				request.setAttribute("message", "검색 실패");
				view.forward(request, response);
			}
		} else {
			ArrayList<QnA> list = new QnAService().selectWriterSearch(keyword);
			RequestDispatcher view = null;
			if (list != null) {
				view = request.getRequestDispatcher("views/main/QnA/QnAList.jsp");
				request.setAttribute("list", list);
				view.forward(request, response);
			} else {
				view = request.getRequestDispatcher("views/main/QnA/QnAError.jsp");
				request.setAttribute("message", "검색 실패");
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
