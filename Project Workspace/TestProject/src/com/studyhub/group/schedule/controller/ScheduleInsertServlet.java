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
 * Servlet implementation class ScheduleInsertServlet
 */
@WebServlet("/scheduleinsert")
public class ScheduleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Schedule sc = new Schedule();
		
		sc.setGroupNo(Integer.parseInt(request.getParameter("group_no")));
		sc.setMeetingDate(request.getParameter("modaldate"));
		sc.setAmpm(request.getParameter("modalampm"));
		sc.setHour(request.getParameter("modalhour"));
		sc.setMinute(request.getParameter("modalminute"));
		sc.setOnoff(request.getParameter("modalonoff"));
		sc.setMeetingName(request.getParameter("modalcontent"));
		String datetype = request.getParameter("datetype_date");
		
		if(new ScheduleService().insertSchedule(sc, datetype) > 0){
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
