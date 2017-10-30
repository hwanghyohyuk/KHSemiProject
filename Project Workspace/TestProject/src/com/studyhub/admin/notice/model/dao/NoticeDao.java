package com.studyhub.admin.notice.model.dao;

import static com.studyhub.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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


	public int insertNotice(Connection con, String notice) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_notice values ( ? )";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, notice);
			
			result = pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
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

