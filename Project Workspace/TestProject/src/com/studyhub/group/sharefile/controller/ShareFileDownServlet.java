package com.studyhub.group.sharefile.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShareFileDownServlet
 */
@WebServlet("/sharefiledown")
public class ShareFileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareFileDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String ofileName = request.getParameter("ofile");
		String rfileName = request.getParameter("rfile");
		
		String savePath = request.getSession().getServletContext().getRealPath("/uploadedfiles");
		
		ServletOutputStream downOut = response.getOutputStream();
		
		File downFile = new File(savePath + "/" + rfileName);
		
		response.setContentType("text/plane; charset=utf-8");
		response.addHeader("Content-Disposition", "attachment; filename=\""
			+ new String(ofileName.getBytes("UTF-8"), "ISO-8859-1")+ "\"");
		response.setContentLength((int)downFile.length());
		
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(downFile));
		
		int read = -1;
		while((read=bin.read())!=-1){
			downOut.write(read);
			downOut.flush();
		}
		downOut.close();
		bin.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
