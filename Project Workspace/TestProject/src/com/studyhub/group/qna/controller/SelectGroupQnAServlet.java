package com.studyhub.group.qna.controller;

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

import com.studyhub.common.vo.GQNA;
import com.studyhub.group.qna.model.service.GroupQnAService;
import com.studyhub.main.qna.model.service.QnAService;

/**
 * Servlet implementation class SelectGroupQnAServlet
 */
@WebServlet("/selectgroupqna")
public class SelectGroupQnAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectGroupQnAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		int startpage = Integer.parseInt(request.getParameter("startpage"));
		int endpage = Integer.parseInt(request.getParameter("endpage"));
		System.out.println(startpage + ", " + endpage);
		ArrayList<GQNA> list = new GroupQnAService().selectGroupQnA(groupno,startpage, endpage);
		
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(GQNA gq : list){
			JSONObject job = new JSONObject();
			job.put("g_qna_no", gq.getgQnaNo());
			job.put("title", URLEncoder.encode(gq.getTitle(), "UTF-8"));
			job.put("content", URLEncoder.encode(gq.getContent(), "UTF-8"));
			job.put("uploaddate", URLEncoder.encode(gq.getStrDate(), "UTF-8"));
			job.put("uploader", URLEncoder.encode(gq.getUploader_name(), "UTF-8"));
			job.put("access_no", gq.getAccessNo());
			job.put("groupno", gq.getGroupNo());
			job.put("user_no", gq.getUploader());
			job.put("commentcount", gq.getCommentcount());
			
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



