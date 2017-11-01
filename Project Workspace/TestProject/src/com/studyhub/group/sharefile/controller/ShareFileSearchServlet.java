package com.studyhub.group.sharefile.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.studyhub.common.vo.GQNA;
import com.studyhub.common.vo.ShareFile;
import com.studyhub.group.sharefile.model.service.ShareFileService;

/**
 * Servlet implementation class ShareFileSearchServlet
 */
@WebServlet("/sharefilesearch")
public class ShareFileSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareFileSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String keyword = request.getParameter("keyword");
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		
		ArrayList<ShareFile> list = new ShareFileService().selectSearch(keyword);
		
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		if(list != null) {
			for(ShareFile sf : list){
				JSONObject job = new JSONObject();
				job.put("fileNo", sf.getFileNo());
				job.put("title", URLEncoder.encode(sf.getTitle(), "UTF-8"));
				job.put("content", URLEncoder.encode(sf.getContent(), "UTF-8"));
				job.put("uploadDate", URLEncoder.encode(sf.getUploadDate().toString(), "UTF-8"));
				job.put("fileName", URLEncoder.encode(sf.getFileName(), "UTF-8"));
				job.put("renameFileName", URLEncoder.encode(sf.getRenameFileName(), "UTF-8"));
				job.put("userName", sf.getUserName());
				job.put("downloadCount", sf.getDownloadCount());
				
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
			response.sendRedirect("views/group/groupFileShare/fileshareList.jsp");
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
