package com.studyhub.group.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.studyhub.common.vo.GNComment;
import com.studyhub.common.vo.GNotice;
import com.studyhub.common.vo.Notice;
import com.studyhub.group.notice.model.dao.GNoticeDao;


import static com.studyhub.common.JDBCTemplate.*;

public class GNoticeService {
	
	private GNotice gNotice;
	private GNoticeDao gNoticeDao;
	
	public GNoticeService(){}
	
	//GNotice
		
	public GNotice selectGNotice(int no){
		Connection conn = getConnection();
		GNotice gnotice = new GNoticeDao().selectOne(conn, no);
		return gnotice;
	}
		
	
	public int insertGNotice(GNotice gNotice){
		Connection conn = getConnection();
		int result = new GNoticeDao().insertGNotice(conn, gNotice);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		return result;
		
	}	
	

	public int deleteGNotice(int bnum) {
		Connection conn = getConnection();
		int result = new GNoticeDao().deleteNotice(conn, bnum);
		if(result >0 )
			commit(conn);
		else
			rollback(conn);
		close(conn);		
		return result;
	}
	
	public int updateGNotice(GNotice gNotice) {
		Connection con = getConnection();
		int result = new GNoticeDao().updateGNotice(con, gNotice);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public ArrayList<GNotice> selectGroupNotice(int groupno, int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<GNotice> list = new GNoticeDao().selectGroupNotice(con, groupno, currentPage, limit);
		close(con);
		return list;
	}

	
	//전체 게시글 갯수 조회
	public int getListCount() {
		Connection con = getConnection();
		int listCount = new GNoticeDao().getListCount(con);
		close(con);
		return listCount;
	}
	
	
	
	// GNoticeComment

	public int deleteComment(int cno) {
		Connection con = getConnection();
		int result = new GNoticeDao().deleteComment(con, cno);
		if(result >0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
		
	}

	public int insertComment(int gnoticeno, String comment, int userno) {
		Connection con = getConnection();
		int result = new GNoticeDao().insertComment(con, gnoticeno, comment, userno);
		if(result>0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public ArrayList<GNComment> selectcomment(int gnoticeno) {
		Connection con = getConnection();
		ArrayList<GNComment> list = new GNoticeDao().selectComment(con, gnoticeno);
		close(con);
		
		return list;
	}


	


	
	
	
	
	
	
	
	
}
