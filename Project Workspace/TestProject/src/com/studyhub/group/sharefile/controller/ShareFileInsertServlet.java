package com.studyhub.group.sharefile.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
import com.studyhub.common.vo.ShareFile;

/**
 * Servlet implementation class ShareFileInsertServlet
 */
@WebServlet("/sharefileinsert")
public class ShareFileInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareFileInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int maxSize = 1024 * 1024 * 10;
		
		RequestDispatcher view = null;
		if(!ServletFileUpload.isMultipartContent(request)){
			view = request.getRequestDispatcher("views/group/groupFileShare/sharefileList.jsp");
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
		
		String originalFileName = mrequest.getFilesystemName("upfile");
		ShareFile sf = null;
		if(originalFileName !=null){
			SimpleDateFormat sdf = 
					new SimpleDateFormat("yyyyMMddHHmmss");
			String renameFileName = sdf.format(
					new java.sql.Date(System.currentTimeMillis())) + "."
					+ originalFileName.substring(
							originalFileName.lastIndexOf(".") + 1);
			
			//renaming
			File originalFile = new File(savePath + "\\" + originalFileName);
			File renameFile = new File(savePath + "\\" + renameFileName);
			
			//파일이름 바꾸기 실행 >> 실패시 직접 바꾸기함
			
			if(!originalFile.renameTo(renameFile)){
				int read = -1;
				byte[] buf = new byte[1024];
				
				FileInputStream fin = new FileInputStream(originalFile);
				FileOutputStream fout = new FileOutputStream(renameFile);
				
				while((read = fin.read(buf, 0, buf.length)) != -1)
					fout.write(buf, 0, read);
				
				fin.close();
				fout.close();
				originalFile.delete();
		}
			sf = new ShareFile(title, content, null,null, userno, accessno, groupno);
			System.out.println(sf+"!");
			
		}else{
			sf = new ShareFile(title, content, null,null, userno, accessno, groupno);
			System.out.println(sf+"@");
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
