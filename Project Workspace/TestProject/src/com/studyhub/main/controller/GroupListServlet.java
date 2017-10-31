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

import com.studyhub.common.vo.Group;
import com.studyhub.main.model.service.MainService;

/**
 * Servlet implementation class GroupListServlet
 */
@WebServlet("/grouplist")
public class GroupListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GroupListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Group> list = new MainService().selectGroupList();

		// 전송할 최종 json 객체
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();

		for (Group g : list) {
			JSONObject job = new JSONObject();
			job.put("group_no", g.getGroupNo());
			job.put("group_name", URLEncoder.encode(g.getGroupName(), "UTF-8"));
			job.put("attribute_no", g.getAttributeNo());
			job.put("location", URLEncoder.encode(g.getLocation(), "UTF-8"));
			job.put("category_no", g.getCategoryNo());
			if(g.getG_img_rename()!=null){
				job.put("g_img_rename", URLEncoder.encode(g.getG_img_rename(), "UTF-8"));
			}else{
				job.put("g_img_rename", URLEncoder.encode("이미지가없습니다.JPG", "UTF-8"));
			}			
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int attrNo = Integer.parseInt(request.getParameter("attrNo"));
		int cateNo = Integer.parseInt(request.getParameter("cateNo"));
		String location = request.getParameter("location");
		String keyword = request.getParameter("keyword");
		ArrayList<Group> list = null;
		list = new MainService().searchGroupList(attrNo,cateNo,location,keyword);
		// 전송할 최종 json 객체
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();

		for (Group g : list) {
			JSONObject job = new JSONObject();
			job.put("group_no", g.getGroupNo());
			job.put("group_name", URLEncoder.encode(g.getGroupName(), "UTF-8"));
			job.put("attribute_no", g.getAttributeNo());
			job.put("location", URLEncoder.encode(g.getLocation(), "UTF-8"));
			job.put("category_no", g.getCategoryNo());
			if(g.getG_img_rename()!=null){
				job.put("g_img_rename", URLEncoder.encode(g.getG_img_rename(), "UTF-8"));
			}else{
				job.put("g_img_rename", URLEncoder.encode("이미지가없습니다.JPG", "UTF-8"));
			}			
			jarr.add(job);
		}
		json.put("list", jarr);
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(json.toJSONString());
		out.flush();
		out.close();
		
	}

}
