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

import com.studyhub.common.vo.GQNA;
import com.studyhub.common.vo.User;
import com.studyhub.group.main.model.service.GMainService;
import com.studyhub.group.qna.model.service.GroupQnAService;

/**
 * Servlet implementation class SearchUserServlet
 */
@WebServlet("/searchuser")
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int userno = Integer.parseInt(request.getParameter("userno"));
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		String search = request.getParameter("search");
		
		ArrayList<Integer> searchlist = new GMainService().SearchSelect(search, groupno);
		
		ArrayList<User> userlist = new GMainService().userlist(userno, groupno, searchlist);
		
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		if(userlist != null) {
			for(User u : userlist){
				JSONObject job = new JSONObject();
				job.put("userno", u.getUserNo());
				job.put("email", URLEncoder.encode(u.getEmail(), "UTF-8"));
				job.put("username", URLEncoder.encode(u.getUserName(), "UTF-8"));
				
				jarr.add(job);
			}
			json.put("list", jarr);
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(json.toJSONString());
			out.flush();
			out.close();
			}
		else {
			response.sendRedirect("views/group/GroupMain.jsp");
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
