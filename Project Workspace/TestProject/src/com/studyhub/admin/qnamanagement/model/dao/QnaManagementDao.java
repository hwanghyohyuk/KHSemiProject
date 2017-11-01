package com.studyhub.admin.qnamanagement.model.dao;

import static com.studyhub.common.JDBCTemplate.close;
import static com.studyhub.common.JDBCTemplate.commit;
import static com.studyhub.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QnaManagementDao {

	public int DeleteQna(Connection con, int qnano) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_qna where qna_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, qnano);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
