package com.studyhub.admin.notice.model.dao;

import static com.studyhub.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.studyhub.common.vo.Board;
import com.studyhub.common.vo.Group;
import com.studyhub.common.vo.Notice;
import com.studyhub.common.vo.QnA;
import com.studyhub.common.vo.UNG;
import com.studyhub.common.vo.User;

public class NoticeDao {

	private Notice notice;	
	private User user;
	private UNG ung;
	private Group group;
	private Board board;

	

	public String selectOne(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select content from tb_notice";
		String notice = " ";
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			while(rset.next()){
			notice = rset.getString("content");
			}
			System.out.println(notice);
			
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(stmt);
		}
		
		return notice;
	}


	public int insertNotice(Connection con, String notice) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_notice set content = ?";
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

	public int deleteNotice(Connection con) {
		int result = 0;
		PreparedStatement pstmt = null;
		String del = " ";
		
		String query = "update tb_notice set content = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, del);
			
			result = pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	
}

