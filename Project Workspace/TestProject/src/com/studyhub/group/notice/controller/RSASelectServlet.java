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

import com.studyhub.common.vo.GBoard;
import com.studyhub.common.vo.RSA;
import com.studyhub.group.notice.model.service.GNoticeService;

/**
 * Servlet implementation class RSASelectServlet
 */
@WebServlet("/rsaselect")
public class RSASelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RSASelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ArrayList<RSA> list = new GNoticeService().SelectRSA();
		
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(RSA r : list) {
			JSONObject job = new JSONObject();
			job.put("id", URLEncoder.encode(r.getId(),"UTF-8"));
			job.put("pwd", URLEncoder.encode(r.getPwd(), "UTF-8"));
			
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
