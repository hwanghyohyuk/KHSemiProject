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

import com.studyhub.common.vo.GNotice;
import com.studyhub.common.vo.Schedule;
import com.studyhub.group.main.model.service.GMainService;

/**
 * Servlet implementation class Top5ScheduleServlet
 */
@WebServlet("/top5schedule")
public class Top5ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Top5ScheduleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		
		ArrayList<Schedule> list = new GMainService().top5schedule(groupno);
		
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(Schedule sc : list) {
			JSONObject job = new JSONObject();
			job.put("noticeno", sc.getScheduleNo());
			job.put("meetingdate", URLEncoder.encode(sc.getMeetingDate(), "UTF-8"));
			job.put("ampm", URLEncoder.encode(sc.getAmpm(), "UTF-8"));
			job.put("hour", URLEncoder.encode(sc.getHour(), "UTF-8"));
			job.put("minute", URLEncoder.encode(sc.getMinute(), "UTF-8"));
			job.put("meetingname", URLEncoder.encode(sc.getMeetingName(), "UTF-8"));
			
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
