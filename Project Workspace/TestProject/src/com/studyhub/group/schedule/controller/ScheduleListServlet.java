package com.studyhub.group.schedule.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.studyhub.common.vo.Schedule;
import com.studyhub.group.schedule.model.service.ScheduleService;

	
/**
 * Servlet implementation class ScheduleListServlet
 */
@WebServlet("/schedulelist")
public class ScheduleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Schedule schedule;
	private ScheduleService scheduleService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		
		ArrayList<Schedule> list = new ScheduleService().selectList(groupno);
		
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(Schedule sc : list) {
			JSONObject job = new JSONObject();
			
			// 데이터 풋 할거 넣어야함
			
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
