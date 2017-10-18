package com.studyhub.admin.notice.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import com.studyhub.common.vo.Board;
import com.studyhub.common.vo.Group;
import com.studyhub.common.vo.Notice;
import com.studyhub.common.vo.UNG;
import com.studyhub.common.vo.User;

public class NoticeDao {

	private Notice notice;	
	private User user;
	private UNG ung;
	private Group group;
	private Board board;

	public ArrayList<Notice> selectList(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<Integer, Notice> selectMap(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}

	public Notice selectOne(Connection con, int no) {
		// TODO Auto-generated method stub
		return null;
	}


	public int insertNotice(Connection con, Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteNotice(Connection con, int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Notice> selectTitleSearch(Connection con, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateNotice(Connection con, Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

