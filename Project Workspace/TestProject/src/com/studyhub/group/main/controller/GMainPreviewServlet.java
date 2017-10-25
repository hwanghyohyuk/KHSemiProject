package com.studyhub.group.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.studyhub.common.vo.Group;
import com.studyhub.group.main.model.service.GMainService;

/**
 * Servlet implementation class GMainPreviewServlet
 */
@WebServlet("/gmainpreview")
public class GMainPreviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private GMainService gms;
	private Group group;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GMainPreviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int group_no = Integer.parseInt(request.getParameter("group_no"));
		int reset = Integer.parseInt(request.getParameter("reset"));
		int user_no = Integer.parseInt(request.getParameter("user_no"));
		
		Group group = null;
		RequestDispatcher view = null;
		if(reset == 1){
			group = new GMainService().SelectGroupMain(group_no);
			JSONObject json = new JSONObject();
			if(group != null){
				json.put("group_no", group.getGroupNo());
				json.put("user_name", URLEncoder.encode(group.getUserName(),"UTF-8"));
				json.put("membercount", group.getMemberCount());
				json.put("category_name", URLEncoder.encode(group.getCategoryName(), "UTF-8"));
				json.put("location", URLEncoder.encode(group.getLocation(), "UTF-8"));
				json.put("attribute_name", URLEncoder.encode(group.getAttributeName(), "UTF-8"));
				
				response.setContentType("application/json; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print(json.toJSONString());
				out.flush();
				out.close();
			}
		}else{
			group = new GMainService().SelectGroup(group_no, user_no);
			if(group != null){
				HttpSession session = request.getSession();
				session.setAttribute("group",group);
				System.out.println("group session : " + session.getId());
				view = request.getRequestDispatcher("/views/group/GroupMain.jsp");
				view.forward(request, response);
			}
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
