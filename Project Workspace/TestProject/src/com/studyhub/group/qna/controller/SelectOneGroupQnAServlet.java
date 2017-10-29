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

/**
 * Servlet implementation class SelectOneGroupQnAServlet
 */
@WebServlet("/selectonegroupqna")
public class SelectOneGroupQnAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneGroupQnAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int gqnano = Integer.parseInt(request.getParameter("g_qna_no"));
		ArrayList<GQNA> list = new GroupQnAService().GroupQnASelectOne(gqnano);
		
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(GQNA gq : list){
			JSONObject job = new JSONObject();
			job.put("g_qna_no", gq.getgQnaNo());
			job.put("title", URLEncoder.encode(gq.getTitle(), "UTF-8"));
			job.put("uploadate", URLEncoder.encode(gq.getStrDate(), "UTF-8"));
			job.put("uploader", URLEncoder.encode(gq.getUploader_name(), "UTF-8"));
			job.put("content", URLEncoder.encode(gq.getContent()));
			
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