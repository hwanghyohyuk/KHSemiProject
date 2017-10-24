package com.studyhub.group.sharefile.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studyhub.common.vo.ShareFile;
import com.studyhub.group.sharefile.model.service.ShareFileService;

/**
 * Servlet implementation class ShareFileUpdateView
 */
@WebServlet("/sharefileupdateview")
public class ShareFileUpdateView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ShareFileService sfs;
	private ShareFile shareFile;	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareFileUpdateView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; utf-8");
		
		ShareFile sf = new ShareFileService().selectShareFile((Integer.parseInt(request.getParameter("no"))));
		
		RequestDispatcher view = null;
		if(sf !=null){
			view = request.getRequestDispatcher("views/group/groupFileShare/fileshareUpdateView.jsp");
			request.setAttribute("sharefile", sf);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("views/group/groupFileShare/fileshareError.jsp");
			request.setAttribute("message", "수정페이지 처리 실패");
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
