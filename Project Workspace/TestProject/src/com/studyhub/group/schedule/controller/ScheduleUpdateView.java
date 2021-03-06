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
 * Servlet implementation class ScheduleUpdateView
 */
@WebServlet("/scheduleupdateview")
public class ScheduleUpdateView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Schedule schedule;
	private ScheduleService scheduleService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleUpdateView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
