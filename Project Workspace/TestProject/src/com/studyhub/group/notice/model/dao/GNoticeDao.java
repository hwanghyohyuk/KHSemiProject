package com.studyhub.group.notice.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.studyhub.common.vo.GNComment;
import com.studyhub.common.vo.GNotice;
import com.studyhub.common.vo.Notice;
import com.studyhub.common.vo.QComment;
import com.studyhub.group.notice.model.service.GNoticeService;
import static com.studyhub.common.JDBCTemplate.*;

public class GNoticeDao {
	private GNotice gNotice;

	public GNoticeDao() {
	}

	// GNotice

	public ArrayList<GNotice> selectList(Connection con) {
		ArrayList<GNotice> list = null;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * from tb_g_notice order by notice_no desc";
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if (rset != null) {
				list = new ArrayList<GNotice>();

				while (rset.next()) {
					GNotice gn = new GNotice();
					gn.setNoticeNo(rset.getInt("notice_no"));
					gn.setTitle(rset.getString("title"));
					gn.setContent(rset.getString("content"));
					gn.setUploadDate(rset.getDate("upload_date"));
					gn.setUploader(rset.getInt("uploader"));
					gn.setAccessNo(rset.getInt("access_no"));
					gn.setGroupNo(rset.getInt("group_no"));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;

	}

	public HashMap<Integer, GNotice> selectMap(Connection conn) {
		HashMap<Integer, GNotice> map = null;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * from tb_g_notice order by notice_no desc";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if (rset != null) {
				map = new HashMap<Integer, GNotice>();

				while (rset.next()) {
					GNotice gn = new GNotice();
					gn.setNoticeNo(rset.getInt("notice_no"));
					gn.setTitle(rset.getString("title"));
					gn.setContent(rset.getString("content"));
					gn.setUploadDate(rset.getDate("upload_date"));
					gn.setUploader(rset.getInt("uploader"));
					gn.setAccessNo(rset.getInt("access_no"));
					gn.setGroupNo(rset.getInt("group_no"));

					map.put(gn.getNoticeNo(), gn);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return map;
	}

	public GNotice selectOne(Connection conn, int no) {
		GNotice gnotice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from gnotice where gnotice_no = ?";

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

	public int insertGNotice(Connection conn, GNotice gnotice) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "insert into tb_g_notice_no values (" + " (select max(g_notice_no) from tb_g_notice),"
				+ " ?, ?, sys_date, ?, 3, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, gnotice.getTitle());
			pstmt.setInt(2, gnotice.getUploader());
			pstmt.setString(3, gnotice.getContent());

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

		String query = "delete from notice where gnotice_no = ?";

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
