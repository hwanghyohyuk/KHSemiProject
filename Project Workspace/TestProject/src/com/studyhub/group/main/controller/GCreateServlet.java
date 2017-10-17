package com.studyhub.group.main.controller;

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
import com.studyhub.common.vo.Group;
import com.studyhub.main.model.service.MainService;

/**
 * Servlet implementation class GCreateServlet
 */
@WebServlet("/gcreate")
public class GCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GCreateServlet() {
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
			view = request.getRequestDispatcher("views/board/boardError.jsp");
			request.setAttribute("message", "form enctype 속성 사용 안 함!");
			view.forward(request, response);
		}
		
		String root = request.getSession().getServletContext().getRealPath("/");
		
		String savePath = root + "images/groupimg";
		
		MultipartRequest mrequest = new MultipartRequest(request, savePath,
				maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		String groupname = mrequest.getParameter("group_name");
		
		int category_no = 0;
		if(mrequest.getParameter("group_category") != null) {
			if(mrequest.getParameter("group_category").equals("토익"))
				category_no = 1;
			if(mrequest.getParameter("group_category").equals("영어회화"))
				category_no = 2;
			if(mrequest.getParameter("group_category").equals("중국어"))
				category_no = 3;
			if(mrequest.getParameter("group_category").equals("제2외국어"))
				category_no = 4;
			if(mrequest.getParameter("group_category").equals("IT/컴퓨터"))
				category_no = 5;
			if(mrequest.getParameter("group_category").equals("독서모임"))
				category_no = 6;
			if(mrequest.getParameter("group_category").equals("취업스터디"))
				category_no = 7;
			if(mrequest.getParameter("group_category").equals("기타"))
				category_no = 8;
		}
		
		int groupon = 2;
		if(mrequest.getParameter("group_on") != null)
			groupon = 1;
		
		String location = "";
		if(mrequest.getParameter("group_location") != null) {
			location = mrequest.getParameter("group_location");
		}
		
		String description = mrequest.getParameter("group_description");
		
		
		String G_IMG_ORIGINAL = mrequest.getFilesystemName("groupimg");
		Group g = null;
		if(G_IMG_ORIGINAL != null){
			//업로드된 파일이 있을 경우, 파일명을 "년월일시분초.확장자"로 변경함
			SimpleDateFormat sdf = 
					new SimpleDateFormat("yyyyMMddHHmmss");
			String G_IMG_RENAME = sdf.format(
					new java.sql.Date(System.currentTimeMillis())) + "."
					+ G_IMG_ORIGINAL.substring(
							G_IMG_ORIGINAL.lastIndexOf(".") + 1);
			
			//업로드되어 있는 원래 파일의 이름을 새 이름으로 바꾸기
			File originalFile = new File(savePath + "\\" + G_IMG_ORIGINAL);
			File renameFile = new File(savePath + "\\" + G_IMG_RENAME);
			
			//파일이름 바꾸기 실행 >> 실패시 직접 바꾸기함
			//새 파일 만들고, 원래 파일의 내용 읽어서 복사 기록하고
			//원 파일 삭제함
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
			g = new Group(groupname, groupon, location, category_no, description, G_IMG_ORIGINAL, G_IMG_RENAME);
		}else  //첨부 파일이 없을 때
			g = new Group(groupname, groupon, location, category_no, description, null, null);
		
		//처리결과에 따라 뷰 지정함
		if(new MainService().insertGroup(g) > 0){
			response.sendRedirect("/studyhub/main.jsp");
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
