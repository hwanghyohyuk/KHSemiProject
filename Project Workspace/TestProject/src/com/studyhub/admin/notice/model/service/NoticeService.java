package com.studyhub.admin.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.studyhub.admin.notice.model.dao.NoticeDao;
import com.studyhub.common.vo.Board;
import com.studyhub.common.vo.Group;
import com.studyhub.common.vo.Notice;
import com.studyhub.common.vo.UNG;
import com.studyhub.common.vo.User;

import static com.studyhub.common.JDBCTemplate.*;

public class NoticeService {
	
	private NoticeDao nDao;
	private Notice notice;	
	private User user;
	private UNG ung;
	private Group group;
	private Board board;
	
	
	public ArrayList<Notice> selectList(){
		Connection con = getConnection();
		ArrayList<Notice> list = new NoticeDao().selectList(con);
		close(con);		
		return list;
		
	}
	
	public HashMap<Integer, Notice> selectMap() {
		Connection con = getConnection();
		HashMap<Integer, Notice> map = new NoticeDao().selectMap(con);
		close(con);
		return map;
	}

	public Notice selectNotice(int no) {
		Connection con = getConnection();
		Notice notice = new NoticeDao().selectOne(con, no);
		close(con);
		return notice;
	}

	public int insertNotice(String notice) {
		Connection con = getConnection();
		int result = new NoticeDao().insertNotice(con, notice);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int deleteNotice(int no) {
		Connection con = getConnection();
		int result = new NoticeDao().deleteNotice(con, no);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int updateNotice(Notice notice) {
		Connection con = getConnection();
		int result = new NoticeDao().updateNotice(con, notice);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public ArrayList<Notice> selectSearch(String keyword) {
		Connection con = getConnection();
		ArrayList<Notice> list = new NoticeDao().selectTitleSearch(con, keyword);
		close(con);
		return list;
	}

	
	
}
