package com.studyhub.group.main.controller;

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

import com.studyhub.common.vo.GBoard;
import com.studyhub.common.vo.Schedule;
import com.studyhub.group.main.model.service.GMainService;

/**
 * Servlet implementation class Top3BoardServlet
 */
@WebServlet("/top3board")
public class Top3BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Top3BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		
		ArrayList<GBoard> list = new GMainService().top3board(groupno);
		
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(GBoard b : list) {
			JSONObject job = new JSONObject();
			job.put("gboardno", b.getgBoardNo());
			job.put("title", URLEncoder.encode(b.getTitle(), "UTF-8"));
			job.put("uploader", URLEncoder.encode(b.getUploaderName(), "UTF-8"));
			job.put("uploaddate", URLEncoder.encode(b.getStrDate(), "UTF-8"));
			
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
