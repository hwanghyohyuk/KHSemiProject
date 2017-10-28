package com.studyhub.group.qna.controller;

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

import com.studyhub.common.vo.GQComment;
import com.studyhub.group.qna.model.dao.GroupQnADao;
import com.studyhub.group.qna.model.service.GroupQnAService;

/**
 * Servlet implementation class GQNACommentSelectServlet
 */
@WebServlet("/gqnacommentselect")
public class GQNACommentSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GQNACommentSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int gqnano = Integer.parseInt(request.getParameter("gqnano"));
		
		ArrayList<GQComment> list = new GroupQnAService().SelectComment(gqnano);
		
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		if(list != null) {
			for(GQComment gqc : list) {
				JSONObject job = new JSONObject();
				job.put("comment_no", gqc.getCommentNo());
				job.put("user_name", URLEncoder.encode(gqc.getUploaderName(), "UTF-8"));
				job.put("content", URLEncoder.encode(gqc.getContent(), "UTF-8"));
				job.put("strdate", URLEncoder.encode(gqc.getStrDate(), "UTF-8"));
				job.put("gqnano", gqc.getgQnaNo());
				job.put("uploader", gqc.getUploader());
				
				jarr.add(job);
			}
			json.put("list", jarr);
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(json.toJSONString());
			out.flush();
			out.close();
			
		} else {
			response.sendRedirect("views/group/groupQnA/QnAList.jsp");
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
