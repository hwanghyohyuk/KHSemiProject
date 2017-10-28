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
 * Servlet implementation class ShareFileInsertViewServlet
 */
@WebServlet("/sharefileinsertview")
public class ShareFileInsertViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareFileInsertViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String 카테고리 이름을 가져와서 writeform에 넣어준다
		
		response.setContentType("text/html; utf-8");
		
		ArrayList<ShareFile> clist = new ShareFileService().selectCategory((Integer.parseInt(request.getParameter("no"))));
		
		RequestDispatcher view = null;
		if(clist!=null){   
			view = request.getRequestDispatcher("views/group/groupFileShare/fileshareWriteform.jsp");
			request.setAttribute("clist", clist);
			view.forward(request, response);
		}else{
			view = request.getRequestDispatcher("views/group/groupFileShare/fileshareError.jsp");
			request.setAttribute("message", "페이지 처리 실패");
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
