package com.studyhub.main.qna.model.dao;

import java.util.ArrayList;
import java.sql.*;


import com.studyhub.common.vo.QnA;
import com.studyhub.common.vo.QComment;
import static com.studyhub.common.JDBCTemplate.*;

public class QnADao {
	
	private QnA qna;
	
	public QnADao() {
	}

	public ArrayList<QnA> selectList(Connection con) {
		ArrayList<QnA> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select qna_no, title, content, upload_date, user_name, access_no from tb_qna "
				+ "join tb_user on (tb_user.user_no=tb_qna.user_no) "
				+ "order by tb_qna.qna_no desc";
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset != null){
				list = new ArrayList<QnA>() ;
				while(rset.next()){
					QnA q = new QnA();
					q.setQnaNo(rset.getInt("qna_no"));
					q.setTitle(rset.getString("title"));
					q.setContent(rset.getString("content"));
					q.setUploadDate(rset.getDate("upload_date"));
					q.setWriter(rset.getString("user_name"));
					q.setAccessNo(rset.getInt("access_no"));
				
					list.add(q);
				}
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public QnA selectOne(Connection con, int no) {

		return null;
	}

	public int insertQnA(Connection con, QnA qna) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_qna values"
				+ "((select max(qna_no)+1 from tb_qna),"
				+ "?, ?, default, ?, ?)";
				
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, qna.getTitle());
			pstmt.setString(2, qna.getContent());
			pstmt.setInt(3, qna.getUserNo());
			pstmt.setInt(4, qna.getAccessNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		return result;
	}

	public int deleteQnA(Connection con, int no) {
		return 0;
	}

	public int updateQnA(Connection con, QnA qna) {
		return 0;
	}

	public ArrayList<QnA> selectTitleSearch(Connection con, String keyword) {
		return null;
	}

	public int insertComment(Connection con, QComment com) {
		return 0;
	}

	public int deleteComment(Connection con, int cno) {
		return 0;
	}

	public int updateReadCount(Connection con, int no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
