package com.studyhub.admin.qnamanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.studyhub.admin.qnamanagement.model.service.QnaManagementService;
import com.studyhub.common.vo.GQNA;
import com.studyhub.common.vo.QnA;
import com.studyhub.group.qna.model.service.GroupQnAService;

/**
 * Servlet implementation class QnaSearchManagementSerlvet
 */
@WebServlet("/qnasearchmanagement")
public class QnaSearchManagementSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaSearchManagementSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String search = request.getParameter("search");
		System.out.println("search :" + search);
		ArrayList<Integer> qnanolist = new QnaManagementService().QnaNoList(search);
		
		ArrayList<QnA> qnalist = new QnaManagementService().QNAlist(qnanolist);
		
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		if(qnalist != null) {
			for(QnA q : qnalist){
				JSONObject job = new JSONObject();
				job.put("qnano", q.getQnaNo());
				job.put("title", URLEncoder.encode(q.getTitle(), "UTF-8"));
				job.put("strdate", URLEncoder.encode(q.getStrDate(), "UTF-8"));
				job.put("writer", URLEncoder.encode(q.getWriter(), "UTF-8"));
				job.put("readcount", q.getReadCount());
				
				jarr.add(job);
			}
			json.put("list", jarr);
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(json.toJSONString());
			out.flush();
			out.close();
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
