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

import com.studyhub.common.vo.Board;
import com.studyhub.main.board.model.service.BoardService;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardpreview")
public class BoardPreviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService bs;
	private Board board;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardPreviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bs = new BoardService();
		ArrayList<Board> list = bs.top5board();
		
		// 전송할 최종 json 객체
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(Board b : list){
			JSONObject job = new JSONObject();

			job.put("board_no", b.getBoardNo());
			job.put("title", URLEncoder.encode(b.getTitle(), "UTF-8"));
			job.put("location", URLEncoder.encode(b.getLocation(), "UTF-8"));
			job.put("category_name", URLEncoder.encode(b.getCategoryName(), "UTF-8"));
			if(b.getgImgRename() == null){
				job.put("renameimg", URLEncoder.encode("이미지가없습니다.JPG", "UTF-8"));
			}
			else {
				job.put("renameimg", URLEncoder.encode(b.getgImgRename(), "UTF-8"));
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
