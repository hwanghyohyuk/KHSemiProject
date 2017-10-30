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
import com.studyhub.group.board.model.service.GBoardService;

/**
 * Servlet implementation class GBoardCommentSelect
 */
@WebServlet("/gbcommentselect")
public class GBoardCommentSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GBoardCommentSelect() {
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

		int gboardno = Integer.parseInt(request.getParameter("gqnano"));

		ArrayList<GBComment> list = new GBoardService().selectcomment(gboardno);

		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();

		if (list != null) {
			for (GBComment gbc : list) {
				JSONObject job = new JSONObject();
				job.put("comment_no", gbc.getCommentNo());
				job.put("content", URLEncoder.encode(gbc.getContent(), "UTF-8"));
				job.put("gqnano", gbc.getgBoardNo());
				job.put("uploader", gbc.getUploader());

				jarr.add(job);
			}
			json.put("list", jarr);
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(json.toJSONString());
			out.flush();
			out.close();

		} else {
			response.sendRedirect("views/group/groupBoard/BoardList.jsp");
		}
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
