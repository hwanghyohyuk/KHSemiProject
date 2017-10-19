package com.studyhub.group.qna.model.dao;

import static com.studyhub.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QnADao {

	public int InsertQnA(Connection con, int userno, int groupno, String title, String content) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_g_qna values ("
					+ " (select max(g_qna_no) from tb_g_qna),"
					+ " ?, ?, sys_date, ?, 3, ?)";
		
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

}
