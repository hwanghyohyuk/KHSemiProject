package com.studyhub.group.sharefile.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.ShareFile;
import com.studyhub.group.sharefile.model.service.ShareFileService;

/**
 * Servlet implementation class ShareFileListServlet
 */
@WebServlet("/sharefilelist")
public class ShareFileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ShareFileService sfs;
	private ShareFile shareFile;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareFileListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html charset=utf-8");
		
		ArrayList<ShareFile> list = new ShareFileService().selectList();
		
		RequestDispatcher view = null;
		
		if(list!=null){
			view = request.getRequestDispatcher("views/group/groupFileShare/fileshareList.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
			
		}else{
			view = request.getRequestDispatcher("views/group/groupFileShare/fileshareError.jsp");
			request.setAttribute("message", "파일 공유 리스트 조회 실패");
			view.forward(request, response);
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
