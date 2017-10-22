package com.studyhub.main.qna.controller;

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

import com.studyhub.common.vo.QComment;
import com.studyhub.main.qna.model.service.QnAService;

/**
 * Servlet implementation class QnACommentSelectServlet
 */
@WebServlet("/qnacommentselect")
public class QnACommentSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnACommentSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qnano = Integer.parseInt(request.getParameter("qnano"));
		ArrayList<QComment> list = new QnAService().selectComment(qnano);
		System.out.println(qnano);
		JSONObject json  = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(QComment qc : list){
			JSONObject job = new JSONObject();
			job.put("qnano", qc.getQnaNo());
			job.put("comment", URLEncoder.encode(qc.getContent(), "UTF-8"));
			job.put("commentno", qc.getCommentNo());
			job.put("uploaddate", URLEncoder.encode(qc.getStrUploadDate(), "UTF-8"));
			job.put("username", URLEncoder.encode(qc.getCommentWriter(), "UTF-8"));
			
			jarr.add(job);
		}
		json.put("list", jarr);
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(json.toJSONString());
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
