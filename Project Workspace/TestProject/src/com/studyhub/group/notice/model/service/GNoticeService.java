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
	
	public int deleteGNotice(int no) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	//GNotice Conmment
	
	public int insertGNComment(GNComment no){
		return 0;
		
	}
	
	public GNComment selectGNComment(int no){
		return null;
		
	}

	
	
	
	
	
	
	
	
	
}
