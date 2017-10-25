package com.studyhub.group.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.studyhub.common.vo.GNComment;
import com.studyhub.common.vo.GNotice;
import com.studyhub.common.vo.Notice;
import com.studyhub.common.vo.QComment;
import com.studyhub.group.notice.model.dao.GNoticeDao;
import com.studyhub.main.qna.model.dao.QnADao;

import static com.studyhub.common.JDBCTemplate.*;

public class GNoticeService {
	
	private GNotice gNotice;
	private GNoticeDao gNoticeDao;
	
	public GNoticeService(){}
	
	//GNotice
	
	public ArrayList<GNotice> selectList(){
		Connection conn = getConnection();
		ArrayList<GNotice> list = new GNoticeDao().selectList(conn);
		close(conn);
		return list;	
		
	}
	
	public HashMap <Integer, GNotice> selectMap(){
		Connection conn = getConnection();
		HashMap <Integer, GNotice> map = new GNoticeDao().selectMap(conn);
		close(conn);
		return map;
	}
	
	public GNotice selectGNotice(int no){
		Connection conn = getConnection();
		GNotice gnotice = new GNoticeDao().selectOne(conn, no);
		return gnotice;
	}
		
	
	public int insertGNotice(GNotice gnotice){
		Connection conn = getConnection();
		int result = new GNoticeDao().insertGNotice(conn, gnotice);
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
