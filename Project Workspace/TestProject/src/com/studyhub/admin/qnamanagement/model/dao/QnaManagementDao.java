package com.studyhub.admin.qnamanagement.model.dao;

import static com.studyhub.common.JDBCTemplate.close;
import static com.studyhub.common.JDBCTemplate.commit;
import static com.studyhub.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.studyhub.common.vo.GQNA;
import com.studyhub.common.vo.QnA;

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

	public ArrayList<Integer> QnaNoList(Connection con, String search) {
		ArrayList<Integer> qnanolist = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		search = "%" + search + "%";
		
		String query = 	"select qna_no, search " +
						"from (select qna_no, title || to_char(upload_date, 'yyyyMMdd') || user_name as search " +
						"from (select qna_no, title, upload_date, user_name " +
						"from tb_qna " +
						"join tb_user using (user_no))) " +
						"where search like ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, search);
			
			rset = pstmt.executeQuery();
			
			if(rset != null){
				qnanolist = new ArrayList<Integer>();
				while(rset.next()){
					int qnano = 0;
					qnano = rset.getInt("qna_no");
					qnanolist.add(qnano);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return qnanolist;
	}

	public ArrayList<QnA> QNAList(Connection con, ArrayList<Integer> qnanolist) {
		ArrayList<QnA> qnalist = new ArrayList<QnA>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			for (int i = qnanolist.size() - 1; i >= 0; i--) {
				QnA q = null;

				String query = "select qna_no, title, to_char(upload_date, 'yyyyMMdd') as str_date, user_name, readcount "
						+ "from tb_qna " + "join tb_user using (user_no) "
						+ "where qna_no = ? " + "order by (qna_no) desc";

				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, qnanolist.get(i));

				rset = pstmt.executeQuery();
				
				
				if (rset.next()) {
					q = new QnA();
					q.setQnaNo(rset.getInt("qna_no"));
					q.setTitle(rset.getString("title"));
					q.setStrDate(rset.getString("str_date"));
					q.setWriter(rset.getString("user_name"));
					q.setReadCount(rset.getInt("readcount"));
					
					qnalist.add(q);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return qnalist;
	}

}
