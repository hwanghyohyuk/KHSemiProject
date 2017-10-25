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

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.studyhub.common.vo.ShareFile;
import com.studyhub.group.sharefile.model.service.ShareFileService;

/**
 * Servlet implementation class ShareFileUpdateServlet
 */
@WebServlet("/sharefileupdate")
public class ShareFileUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ShareFileService sfs;
	private ShareFile shareFile;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareFileUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		RequestDispatcher view = null;
		ShareFile sf = null;
		int returnedResult = 0;
		
		if(!ServletFileUpload.isMultipartContent(request)){
			view = request.getRequestDispatcher("views/group/groupFileShare/fileshareError.jsp");
			request.setAttribute("message", "form의 enctype속성 누락");
			view.forward(request, response);
		}	
			int maxSize = 1024* 1024 * 10;
			
			String root = request.getSession().getServletContext().getRealPath("/");
			String savePath = root + "uploadedfiles";
			
			MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			int fileno = Integer.parseInt(mrequest.getParameter("fileno"));
			String title = mrequest.getParameter("title");
			int userno = Integer.parseInt(mrequest.getParameter("user_no"));
			String content = mrequest.getParameter("content");
			int accessno = Integer.parseInt(mrequest.getParameter("access_no"));
			int groupno = Integer.parseInt(mrequest.getParameter("group_no"));
			
			
			String originalFileName = mrequest.getFilesystemName("upfile");
			System.out.println("뭐가들어가니?" + originalFileName);
			//첨부파일까지 같이 수정할때 
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
				sf = new ShareFile(fileno, title, content, originalFileName,renameFileName, userno, accessno, groupno);
				returnedResult = new ShareFileService().updateShareFile(sf);
			}else{
				//첨부파일은 그대로 두고 제목 내용만 수정할 때 
				System.out.println("이리와야하는데 ㅠㅠㅠ ");
				sf = new ShareFile(fileno, title, content);
				returnedResult = new ShareFileService().updateTextOnly(sf);
			}
		
			if(returnedResult > 0){
				response.sendRedirect("/studyhub/sharedfilepreview?groupno="+groupno);
			}else{
				view = request.getRequestDispatcher("views/group/groupFileShare/fileshareError.jsp");
				request.setAttribute("message", "글 수정 실패!");
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
