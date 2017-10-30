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

import com.studyhub.common.vo.Schedule;
import com.studyhub.common.vo.ShareFile;
import com.studyhub.group.main.model.service.GMainService;

/**
 * Servlet implementation class Top3ShareFileServlet
 */
@WebServlet("/top3sharefile")
public class Top3ShareFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Top3ShareFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		
		ArrayList<ShareFile> list = new GMainService().top3sharefile(groupno);
		
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(ShareFile sf : list) {
			JSONObject job = new JSONObject();
			job.put("fileno", sf.getFileNo());
			job.put("title", URLEncoder.encode(sf.getTitle(), "UTF-8"));
			job.put("uploader", URLEncoder.encode(sf.getUserName(), "UTF-8"));
			job.put("uploaddate", URLEncoder.encode(sf.getStrDate(), "UTF-8"));
			
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
