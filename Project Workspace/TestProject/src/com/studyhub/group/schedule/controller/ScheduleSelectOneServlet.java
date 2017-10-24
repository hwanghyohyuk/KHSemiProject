package com.studyhub.group.schedule.controller;

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
import com.studyhub.group.schedule.model.service.ScheduleService;

/**
 * Servlet implementation class ScheduleSelectOneServlet
 */
@WebServlet("/scheduleselectone")
public class ScheduleSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int scheduleno = Integer.parseInt(request.getParameter("scheduleno"));
		ArrayList<Schedule> list = new ScheduleService().selectOne(scheduleno);
		
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(Schedule sc : list) {
			JSONObject job = new JSONObject();
			job.put("schedule_no", sc.getScheduleNo());
			job.put("meeting_date", URLEncoder.encode(sc.getMeetingDate(), "UTF-8"));
			job.put("ampm", URLEncoder.encode(sc.getAmpm(), "UTF-8"));
			job.put("hour", URLEncoder.encode(sc.getHour(), "UTF-8"));
			job.put("minute", URLEncoder.encode(sc.getMinute(), "UTF-8"));
			job.put("onoff", URLEncoder.encode(sc.getOnoff(), "UTF-8"));
			job.put("meeting_name", URLEncoder.encode(sc.getMeetingName(), "UTF-8"));
						
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
