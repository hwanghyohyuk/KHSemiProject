package com.studyhub.group.notice.controller;

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

import com.studyhub.common.vo.GNComment;
import com.studyhub.group.notice.model.service.GNoticeService;

/**
 * Servlet implementation class GNoticeCommentSelectServlet
 */
@WebServlet("/gnoticecommentselect")
public class GNoticeCommentSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GNoticeCommentSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gnoticeno = Integer.parseInt(request.getParameter("gnoticeno"));
		ArrayList<GNComment> list = new GNoticeService().selectcomment(gnoticeno);
		System.out.println(gnoticeno);
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(GNComment gnc : list){
			JSONObject job = new JSONObject();
			job.put("gnoticeno", gnc.getNoticeNo());
			job.put("comment", URLEncoder.encode(gnc.getContent(), "UTF-8"));
			job.put("commentno", gnc.getCommentNo());
			job.put("uploaddate", URLEncoder.encode(gnc.getStrUploadDate(), "UTF-8"));
			job.put("username", URLEncoder.encode(gnc.getUploaderName(), "UTF-8"));
			
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
