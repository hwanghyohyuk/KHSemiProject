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

import com.studyhub.common.vo.Message;
import com.studyhub.common.vo.UNG;
import com.studyhub.main.model.service.MainService;

/**
 * Servlet implementation class MessageSelectServlet
 */
@WebServlet("/messagelist")
public class MessageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int userno = Integer.parseInt(request.getParameter("userno"));
		
		ArrayList<Message> list = new MainService().MessageSelect(userno);
		
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(Message m : list){
			JSONObject job = new JSONObject();
			job.put("messageno", m.getMessageNo());
			job.put("message", URLEncoder.encode(m.getMessage(),"UTF-8"));
			job.put("groupno", m.getGroupNo());
			job.put("groupname", URLEncoder.encode(m.getGroupName(), "UTF-8"));
			job.put("sender", m.getSenderNo());
			job.put("receiver", m.getReceiverNo());
			job.put("messagestate", m.getMessageState());
			job.put("username", URLEncoder.encode(m.getUserName(), "UTF-8"));

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
