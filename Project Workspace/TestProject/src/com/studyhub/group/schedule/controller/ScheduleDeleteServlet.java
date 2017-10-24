package com.studyhub.group.schedule.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.Schedule;
import com.studyhub.group.schedule.model.service.ScheduleService;

/**
 * Servlet implementation class ScheduleDeleteServlet
 */
@WebServlet("/scheduledelete")
public class ScheduleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ScheduleService scheduleService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int scheduleno = Integer.parseInt(request.getParameter("schedule_no"));
		
		if(new ScheduleService().deleteSchedule(scheduleno) > 0) {
			response.sendRedirect("views/group/groupSchedule/ScheduleMain.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
