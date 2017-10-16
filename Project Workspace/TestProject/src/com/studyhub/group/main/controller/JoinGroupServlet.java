package com.studyhub.group.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.studyhub.common.vo.UNG;
import com.studyhub.group.main.model.service.GMainService;

/**
 * Servlet implementation class JoinGroupServlet
 */
@WebServlet("/joingroup")
public class JoinGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinGroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//가입된 그룹을 인원수 많은 세개만 우선 보여주기
		int userno = Integer.parseInt(request.getParameter("userno"));
		
		ArrayList<UNG> list = new GMainService().selectJoinGroup(userno);
		
		// 전송할 최종 json 객체
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(UNG ung : list){
			
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
