package com.studyhub.group.notice.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.studyhub.common.vo.GNComment;
import com.studyhub.common.vo.GNotice;
import com.studyhub.group.notice.model.service.GNoticeService;
import static com.studyhub.common.JDBCTemplate.*;

public class GNoticeDao {
	private GNotice gNotice;

	public GNoticeDao() {
	}

	public GNotice selectOne(Connection conn, int no) {
		GNotice gnotice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from tb_g_notice where notice_no = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				gnotice = new GNotice();
				gnotice.setNoticeNo(rset.getInt("notice_no"));
				gnotice.setTitle(rset.getString("title"));
				gnotice.setContent(rset.getString("content"));
				gnotice.setUploadDate(rset.getDate("upload_date"));
				gnotice.setUploader(rset.getInt("uploader"));
				gnotice.setAccessNo(rset.getInt("access_no"));
				gnotice.setGroupNo(rset.getInt("group_no"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return gnotice;
	}

	public int insertGNotice(Connection conn, GNotice gNotice) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "insert into tb_g_notice values ((select max(notice_no)+1 from tb_g_notice),"
				+ " ?, ?, sysdate, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, gNotice.getTitle());
			pstmt.setString(2, gNotice.getContent());
			pstmt.setInt(3, gNotice.getUploader());
			pstmt.setInt(4, gNotice.getAccessNo());
			pstmt.setInt(5, gNotice.getGroupNo());
			
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteNotice(Connection conn, int bnum) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "delete from tb_g_notice where notice_no = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bnum);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}

		return result;
	}
	
	public ArrayList<GNotice> selectGroupNotice(Connection con, int groupno, int currentPage, int limit) {
		//공지 목록 조회
		
		ArrayList<GNotice> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		//String query = "select notice_no, title, content, uploader, upload_date, access_no" + " from tb_g_notice"
		//		+ " join tb_user on (tb_g_notice.uploader=tb_user.user_no)" + " where group_no = ?";

		String query="select rownum, notice_no, title, content, uploader, upload_date, user_name, access_no, access_right "
				+ "from(select * from tb_g_notice join tb_user on(tb_user.user_no=tb_g_notice.uploader) join tb_access using(access_no) "
				+ "where group_no=? order by notice_no asc) where rownum >=? and rownum<=? order by rownum desc";
				
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		        
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			if (rset != null) {
				list = new ArrayList<GNotice>();
				while (rset.next()){
				GNotice gn = new GNotice();
				gn.setRownum(rset.getInt("rownum"));
				gn.setNoticeNo(rset.getInt("notice_no"));
				gn.setTitle(rset.getString("title"));
				gn.setContent(rset.getString("content"));
				gn.setUploader(rset.getInt("uploader"));
				gn.setUploader_name(rset.getString("user_name"));
				gn.setUploadDate(rset.getDate("upload_date"));
				gn.setAccessNo(rset.getInt("access_no"));
				gn.setAccessName(rset.getString("access_right"));
				System.out.println(gn);
				list.add(gn);
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
	

	public int getListCount(Connection con) {
		//공지 총 갯수 조회
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from tb_g_notice";
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next())
				result = rset.getInt(1);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(stmt);
		}
		return result;
	}
	

	public int updateGNotice(Connection con, GNotice gNotice) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, gNotice.getTitle());
			pstmt.setString(2, gNotice.getContent());
			pstmt.setInt(3, gNotice.getNoticeNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}

	
	

	// GNotice Comment
	public int deleteComment(Connection con, int cno) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "delete from tb_gnotice_comment where comment_no =? ";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cno);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertComment(Connection con, int gnoticeno, String comment, int userno) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, gnoticeno);
			pstmt.setString(2, comment);
			pstmt.setInt(3, userno);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<GNComment> selectComment(Connection con, int gnoticeno) {
		ArrayList<GNComment> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, gnoticeno);

			rset = pstmt.executeQuery();
			if (rset != null) {
				list = new ArrayList<GNComment>();
				while (rset.next()) {
					GNComment gnc = new GNComment();
					gnc.setCommentNo(rset.getInt("comment_no"));
					gnc.setNoticeNo(rset.getInt("notice_no"));
					gnc.setContent(rset.getString("content"));
					gnc.setUploadDate(rset.getDate("uploade_date"));
					gnc.setUploader(rset.getInt("uploader"));

					list.add(gnc);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(list);
		return list;
	}


	

}
