package com.studyhub.group.notice.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.studyhub.common.vo.GNotice;
import com.studyhub.common.vo.Notice;
import com.studyhub.group.notice.model.service.GNoticeService;

public class GNoticeDao {
	private GNotice gNotice;
	
	
	public GNoticeDao(){}
	
	
	
	
	//GNotice

	public ArrayList<GNotice> selectList(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}	

	public HashMap<Integer, GNotice> selectMap(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	public GNotice selectOne(Connection conn, int no) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateReadCount(Connection conn, int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertGNotice(Connection conn, GNotice gnotice) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<GNotice> selectTitleSearch(Connection conn, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}

