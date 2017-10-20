package com.studyhub.group.qna.model.dao;

import static com.studyhub.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.studyhub.common.vo.GQNA;

public class GroupQnADao {

	public int InsertQnA(Connection con, int userno, int groupno, String title, String content) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_g_qna values ("
					+ " (select max(g_qna_no)+1 from tb_g_qna),"
					+ " ?, ?, sysdate, ?, 3, ?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, userno);
			pstmt.setInt(4, groupno);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<GQNA> selectGroupQnA(Connection con, int groupno) {
		ArrayList<GQNA> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = 	"select g_qna_no, title, content, to_char(upload_date, 'yyyyMMdd') as str_date, user_name, access_no, group_no " +
						"from tb_g_qna " +
						"join tb_user on (tb_g_qna.uploader = tb_user.user_no) " +
						"where group_no = ? " + 
						"order by (g_qna_no) desc";
			
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			
			rset = pstmt.executeQuery();
			if(rset != null){
				list = new ArrayList<GQNA>();
				while(rset.next()){
					GQNA gq = new GQNA();
					gq.setgQnaNo(rset.getInt("g_qna_no"));
					gq.setTitle(rset.getString("title"));
					gq.setContent(rset.getString("content"));
					gq.setStrDate(rset.getString("str_date"));
					gq.setUploader_name(rset.getString("user_name"));
					gq.setAccessNo(rset.getInt("access_no"));
					gq.setGroupNo(rset.getInt("group_no"));
					
					list.add(gq);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int deleteGroupQnA(Connection con, int gqnano) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_g_qna"
					+ " where g_qna_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, gqnano);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
