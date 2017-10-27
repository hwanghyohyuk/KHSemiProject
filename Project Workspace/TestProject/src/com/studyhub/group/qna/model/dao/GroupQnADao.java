package com.studyhub.group.qna.model.dao;

import static com.studyhub.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.studyhub.common.vo.GQComment;
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
		
		String query = 	"select g_qna_no, title, content, to_char(upload_date, 'yyyyMMdd') as str_date, user_name, access_no, group_no, uploader " +
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
					gq.setUploader(rset.getInt("uploader"));
					
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

	public ArrayList<GQNA> GroupQnASelectOne(Connection con, int gqnano) {
		ArrayList<GQNA> list = null;
		
		PreparedStatement pstmt = null;;
		ResultSet rset = null;
		
		String query = "select g_qna_no, title, content, to_char(upload_date, 'yyyyMMdd') as str_date, user_name " +
					"from tb_g_qna " +
					"join tb_user on (tb_g_qna.uploader = tb_user.user_no) " +
					"where g_qna_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, gqnano);
			
			rset = pstmt.executeQuery();
			if(rset != null){
				list = new ArrayList<GQNA>();
				while(rset.next()){
					GQNA gq = new GQNA();
					gq.setgQnaNo(gqnano);
					gq.setTitle(rset.getString("title"));
					gq.setContent(rset.getString("content"));
					gq.setStrDate(rset.getString("str_date"));
					gq.setUploader_name("user_name");
					System.out.println(gq);
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

	public int UpdateGroupQnA(Connection con, int gqnano, String title, String content) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "update tb_g_qna set title = ?, content = ? where g_qna_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, gqnano);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Integer> GroupNoList(Connection con, int groupno, String searchdata) {
		ArrayList<Integer> groupnolist = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		searchdata = "%" + searchdata + "%";
		
		String query = 	"select g_qna_no, group_no, searchdata " +
						"from (select g_qna_no, group_no, title || content || to_char(upload_date, 'yyyyMMdd') || user_name as searchdata " +
						"from (select g_qna_no, group_no, title, content, upload_date, user_name " +
						"from tb_g_qna " +
						"join tb_user on (user_no=uploader)) " +
						"where group_no = ?) " +
						"where searchdata like ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			pstmt.setString(2, searchdata);
			
			rset = pstmt.executeQuery();
			
			if(rset != null){
				groupnolist = new ArrayList<Integer>();
				while(rset.next()){
					int gqnano = 0;
					gqnano = rset.getInt("g_qna_no");
					groupnolist.add(gqnano);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return groupnolist;
	}

	public ArrayList<GQNA> GQNAList(Connection con, int groupno, ArrayList<Integer> groupnolist) {
		ArrayList<GQNA> qnalist = new ArrayList<GQNA>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			for (int i = 0; i < groupnolist.size(); i++) {
				System.out.println(i);
				GQNA gq = null;

				String query = "select g_qna_no, title, content, to_char(upload_date, 'yyyyMMdd') as str_date, user_name, access_no, group_no, uploader "
						+ "from tb_g_qna " + "join tb_user on (tb_g_qna.uploader = tb_user.user_no) "
						+ "where group_no = ? and g_qna_no = ? " + "order by (g_qna_no) desc";

				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, groupno);
				pstmt.setInt(2, groupnolist.get(i));

				rset = pstmt.executeQuery();
				
				
				if (rset.next()) {
					gq = new GQNA();
					gq.setgQnaNo(rset.getInt("g_qna_no"));
					gq.setTitle(rset.getString("title"));
					gq.setContent(rset.getString("content"));
					gq.setStrDate(rset.getString("str_date"));
					gq.setUploader_name(rset.getString("user_name"));
					gq.setAccessNo(rset.getInt("access_no"));
					gq.setGroupNo(rset.getInt("group_no"));
					gq.setUploader(rset.getInt("uploader"));
					
					qnalist.add(gq);
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

	public ArrayList<GQComment> SelectComment(Connection con, int gqnano) {
		ArrayList<GQComment> list = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select comment_no, content, to_char(upload_date, 'yyyy-MM-dd') as str_date, user_name, g_qna_no, uploader "
					+ "from tb_gq_comment "
					+ "join tb_user on (uploader=user_no) "
					+ "where g_qna_no = ? "
					+ "order by comment_no asc";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, gqnano);
			
			rset = pstmt.executeQuery();
			if(rset != null) {
				list = new ArrayList<GQComment>();
				while(rset.next()) {
					GQComment gqc = new GQComment();
					gqc.setCommentNo(rset.getInt("comment_no"));
					gqc.setUploaderName(rset.getString("user_name"));
					gqc.setStrDate(rset.getString("str_date"));
					gqc.setContent(rset.getString("content"));
					gqc.setgQnaNo(rset.getInt("g_qna_no"));
					gqc.setUploader(rset.getInt("uploader"));
					
					list.add(gqc);
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

	public int DeleteComment(Connection con, int commentno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_gq_comment where comment_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, commentno);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int InsetComment(Connection con, int gqnano, int userno, String content) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_gq_comment values ( " +
						"(select max(comment_no)+1 from tb_gq_comment), " +
						"?, ?, sysdate, ?, 1)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, gqnano);
			pstmt.setString(2, content);
			pstmt.setInt(3, userno);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


}
