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
 * Servlet implementation class ShareFileDeleteServlet
 */
@WebServlet("/sharefiledelete")
public class ShareFileDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ShareFileService sfs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShareFileDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		int groupno = Integer.parseInt(request.getParameter("groupno"));
		int fileno = Integer.parseInt(request.getParameter("fileno"));

		if (new ShareFileService().deleteShareFile(fileno) > 0) {
			
			response.sendRedirect("/studyhub/sharedfilepreview?groupno="+groupno);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/group/groupFileShare/fileshareError.jsp");
			request.setAttribute("message", "게시글 삭제 처리 실패!");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
