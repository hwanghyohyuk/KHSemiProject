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
		
		String query = "select qna_no, title, content, upload_date, user_name, access_no, readcount from tb_qna "
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
					q.setReadCount(rset.getInt("readcount"));
				
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
		QnA qna = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_qna where qna_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				qna = new QnA();
				qna.setQnaNo(rset.getInt("qna_no"));
				qna.setTitle(rset.getString("title"));
				qna.setContent(rset.getString("content"));
				qna.setUploadDate(rset.getDate("upload_date"));
				qna.setUserNo(rset.getInt("user_no"));
				qna.setAccessNo(rset.getInt("access_no"));
				qna.setReadCount(rset.getInt("readcount"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pstmt);
		}
		
		return qna;
	}

	public int insertQnA(Connection con, QnA qna) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_qna values"
				+ "((select max(qna_no)+1 from tb_qna),"
				+ "?, ?, sysdate, ?, ?, 1)";
				
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
		int result =0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_qna where qna_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		return result;
	}

	public int updateQnA(Connection con, QnA qna) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_qna set title = ?, content = ? "
				+"where qna_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, qna.getTitle());
			pstmt.setString(2, qna.getContent());
			pstmt.setInt(3, qna.getQnaNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}
	
	public int updateReadCount(Connection con, int no){
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_qna set readcount = readcount+1 where qna_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<QnA> selectTitleSearch(Connection con, String keyword) {
		return null;
	}

	public int insertComment(Connection con, int qnano, String comment, int userno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_qna_comment values("+
					"(select max(comment_no)+1 from tb_qna_comment),"+
					"?, ?, sysdate, ?, 1)";
		
		try{
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, qnano);
			pstmt.setString(2, comment);
			pstmt.setInt(3, userno);
			
			result = pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<QComment> selectComment(Connection con, int qnano) {
		ArrayList<QComment> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select comment_no, qna_no, content, to_char(upload_date, 'yyyyMMdd') as str_date, user_name "+
						"from tb_qna_comment "
				+"join tb_user on (tb_qna_comment.user_no = tb_user.user_no) "
						+"where qna_no = 1 order by comment_no desc";
		
		try{
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, qnano);
			
			rset = pstmt.executeQuery();
			if(rset !=null){
				list = new ArrayList<QComment>();
				while(rset.next()){
					QComment qc = new QComment();
					qc.setCommentNo(rset.getInt("comment_no"));
					qc.setQnaNo(rset.getInt("qna_no"));
					qc.setContent(rset.getString("content"));
					qc.setStrUploadDate(rset.getString("str_date"));
					qc.setCommentWriter(rset.getString("user_name"));
					
					list.add(qc);
				}
				
			}} catch(Exception e){
				e.printStackTrace();
			} finally{
				close(rset);
				close(pstmt);
			}
	}

	public int deleteComment(Connection con, int cno) {
		return 0;
	}

	


}
