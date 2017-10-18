package com.studyhub.main.controller;

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

import com.studyhub.common.vo.UNG;
import com.studyhub.group.main.model.service.GMainService;
import com.studyhub.main.model.service.MainService;

/**
 * Servlet implementation class MyGroupPreviewServlet
 */
@WebServlet("/mygrouppreview")
public class MyGroupPreviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyGroupPreviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userno = Integer.parseInt(request.getParameter("userno"));
		
		ArrayList<UNG> list = new MainService().selectJoinGroup(userno);
		
		// 전송할 최종 json 객체
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(UNG ung : list){
			JSONObject job = new JSONObject();
			job.put("group_no", ung.getGroupNo());
			job.put("group_name", URLEncoder.encode(ung.getGroupName(),"UTF-8"));
			job.put("usercoun", ung.getCount());
			job.put("renameimg", URLEncoder.encode(ung.getRenameimg(), "UTF-8"));
			
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
