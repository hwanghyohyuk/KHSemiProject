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
	
	

	public String selectNotice() {
		Connection con = getConnection();
		String notice = new NoticeDao().selectOne(con);
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

	
	
}
