package com.studyhub.group.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.studyhub.common.vo.GBoard;
import com.studyhub.common.vo.ShareFile;
import com.studyhub.group.board.model.service.GBoardService;


/**
 * Servlet implementation class GBoardInsertServlet 
 */
@WebServlet("/gboardinsert")
public class GBoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GBoard gNboard;
	private GBoardService gNboardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GBoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				/*request.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				
				RequestDispatcher view = null;

				if(!ServletFileUpload.isMultipartContent(request)){
					view = request.getRequestDispatcher("/views/group/groupBoard/BoardError.jsp");
					request.setAttribute("message", "form enctype 속성 사용 안 함!");
					view.forward(request, response);
				}
				GBoard gboard = new GBoard();

				int boardNo = Integer.parseInt(request.getParameter("g_board_no"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				String uploader = request.getParameter("uploader");
				String strDate = request.getParameter("strdate");
				int readcount = Integer.parseInt(request.getParameter("readcount"));
				int accessNo = Integer.parseInt(request.getParameter("access_no"));
				int groupNo = Integer.parseInt(request.getParameter("group_no"));
				
				gboard.setgBoardNo(boardNo);
				gboard.setTitle(title);
				gboard.setContent(content);
				gboard.setUploader(uploader);
				gboard.setStrDate(strDate);
				gboard.setReadcount(readcount);
				gboard.setAccessNo(accessNo);
				gboard.setGroupNo(groupNo);
				
				
				gboard = new GBoard(boardNo, title, content, uploader,strDate,readcount, accessNo, groupNo);
				
				if(new GBoardService().insertBoard(gboard)>0){
					response.sendRedirect("/studyhub/gboardlist");
				}else{
					RequestDispatcher errorPage = request.getRequestDispatcher("/views/group/groupBoard/BoardError.jsp");
					request.setAttribute("message", "질문 등록 실패");
					errorPage.forward(request, response);
				}*/request.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				
				int maxSize = 1024 * 1024 * 10;
				
				RequestDispatcher view = null;
				if(!ServletFileUpload.isMultipartContent(request)){
					view = request.getRequestDispatcher("views/group/groupBoard/BoardError.jsp");
					request.setAttribute("message", "enctype속성 사용안함!");
					view.forward(request, response);
				}
				String root = request.getSession().getServletContext().getRealPath("/");
				String savePath = root + "uploadedfiles";
				
				MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
				
				String title = mrequest.getParameter("title");
				int userno = Integer.parseInt(mrequest.getParameter("user_no"));
				String content = mrequest.getParameter("content");
				int accessno = Integer.parseInt(mrequest.getParameter("access_no"));
				int groupno = Integer.parseInt(mrequest.getParameter("group_no"));
				

				GBoard sf= null;
				
				if(new GBoardService().insertBoard(sf) > 0){
					response.sendRedirect("/studyhub/gboardpreview?groupno="+groupno);
				}else{
					view = request.getRequestDispatcher("views/group/groupBoard/BoardError.jsp");
					request.setAttribute("message", "서비스 : 글 등록 실패!");
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
