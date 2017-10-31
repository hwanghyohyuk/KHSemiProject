package com.studyhub.group.board.controller;

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

import com.studyhub.common.vo.GBComment;
import com.studyhub.common.vo.GBoard;
import com.studyhub.group.board.model.service.GBoardService;

/**
 * Servlet implementation class GBoardCommentSelect
 */
@WebServlet("/gbcommentselect")
public class GBoardCommentSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GBoard gboard;
	private GBoardService gboardService;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GBoardCommentSelectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int gboardno = Integer.parseInt(request.getParameter("gboardno"));
		ArrayList<GBComment> list = new GBoardService().selectcomment(gboardno);
		System.out.println(gboardno);
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(GBComment gbc : list){
			JSONObject job = new JSONObject();
			job.put("gnoticeno", gbc.getgBoardNo());
			job.put("comment", URLEncoder.encode(gbc.getContent(), "UTF-8"));
			job.put("commentno", gbc.getCommentNo());
			job.put("uploaddate", URLEncoder.encode(gbc.getStrUploadDate(), "UTF-8"));
			job.put("username", URLEncoder.encode(gbc.getUploaderName(), "UTF-8"));
			
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
