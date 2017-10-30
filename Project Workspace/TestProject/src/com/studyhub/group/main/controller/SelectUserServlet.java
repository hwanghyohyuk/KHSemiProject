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
import com.studyhub.common.vo.UNG;
import com.studyhub.common.vo.User;
import com.studyhub.group.main.model.service.GMainService;

/**
 * Servlet implementation class SelectUserServlet
 */
@WebServlet("/selectuser")
public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		int userno = Integer.parseInt(request.getParameter("userno"));
		int authorityno = Integer.parseInt(request.getParameter("authorityno"));
		
		
		ArrayList<UNG> list = null;
		if(authorityno == 2){
			list = new GMainService().SelectUser(groupno, userno);
		}
		else {
			list = new GMainService().SelectUser2(groupno, userno);
		}
		
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(UNG u : list) {
			JSONObject job = new JSONObject();
			job.put("ungno", u.getUngNo());
			job.put("email", URLEncoder.encode(u.getEmail(), "UTF-8"));
			job.put("username", URLEncoder.encode(u.getUserName(), "UTF-8"));
			job.put("ungstate", u.getUngState());
			job.put("authorityno", u.getAuthorityNo());
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
