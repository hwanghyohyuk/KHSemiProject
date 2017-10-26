package com.studyhub.group.main.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.*;

import static com.studyhub.common.JDBCTemplate.*;

import com.studyhub.common.vo.GBoard;
import com.studyhub.common.vo.GNotice;
import com.studyhub.common.vo.GQNA;
import com.studyhub.common.vo.Group;
import com.studyhub.common.vo.Schedule;
import com.studyhub.common.vo.ShareFile;
import com.studyhub.common.vo.UNG;

public class GMainDao {

	private Group group;
	private GBoard gBoard;
	private GNotice gNotice;
	private GQNA gQna;
	private Schedule schedule;
	private ShareFile shareFile;

	public Group selectGroup(Connection con, int group_no, int user_no) {
		group = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select group_no ,group_name, attribute_name, location, category_name, description, authority_no"
					+ " from tb_group"
					+ " join tb_on_off using(attribute_no)"
					+ " join tb_category using(category_no)"
					+ " join (select group_no, authority_no from tb_ung where user_no=?) using(group_no)"
					+ " where group_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, user_no);
			pstmt.setInt(2, group_no);

			rset = pstmt.executeQuery();
			if (rset.next()) {
				group = new Group();

				group.setGroupNo(group_no);
				group.setGroupName(rset.getString("group_name"));
				group.setAttributeName(rset.getString("attribute_name"));
				group.setLocation(rset.getString("location"));
				group.setCategoryName(rset.getString("category_name"));
				group.setDescription(rset.getString("description"));
				group.setAuthorityNo(rset.getInt("authority_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return group;
	}

	public Group SelectGroupMain(Connection con, int group_no) {
		Group g = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select group_no, user_name, membercount, category_name, location, attribute_name "
				+ "from tb_group " + "join (select group_no, user_name " + "from tb_ung "
				+ "join tb_user using(user_no) " + "where authority_no = 2) using (group_no) "
				+ "join (select group_no, category_name " + "from tb_group "
				+ "join tb_category using (category_no)) using(group_no) " + "join (select group_no, attribute_name "
				+ "from tb_on_off " + "join tb_group using(attribute_no)) using(group_no) "
				+ "join (select group_no, count(*) as membercount " + "from tb_ung "
				+ "group by group_no) using(group_no) " + "where group_no = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, group_no);

			rset = pstmt.executeQuery();
			if (rset.next()) {
				g = new Group();
				g.setGroupNo(rset.getInt("group_no"));
				g.setUserName(rset.getString("user_name"));
				g.setMemberCount(rset.getInt("membercount"));
				g.setCategoryName(rset.getString("category_name"));
				g.setLocation(rset.getString("location"));
				g.setAttributeName(rset.getString("attribute_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return g;
	}

	public ArrayList<GNotice> selectGroupNotice(Connection con, int groupno) {
		ArrayList<GNotice> list = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select notice_no, title, uploader, upload_date" + " from tb_g_notice"
				+ " join tb_user on (tb_g_notice.uploader=tb_user.user_no)" + " where notice_no = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);

			rset = pstmt.executeQuery();
			if (rset != null) {
				list = new ArrayList<GNotice>();
				while (rset.next())
					;
				GNotice gn = new GNotice();
				gn.setNoticeNo(rset.getInt("notice_no"));
				gn.setTitle(rset.getString("title"));
				gn.setUploader(rset.getInt("uploader"));
				gn.setUploadDate(rset.getDate("upload_date"));
				System.out.println(gn);
				list.add(gn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<GBoard> selectGroupBoard(Connection con, int groupno) {
		ArrayList<GBoard> list = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select g_board_no, title,content, uploader, to_char(upload_date, 'yyyyMMdd') as strdate, readcount,access_no,group_no"
				+ " from tb_g_board" + " join tb_user on (tb_g_board.uploader=tb_user.user_no)" + " where group_no = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);

			rset = pstmt.executeQuery();
			if (rset != null) {
				list = new ArrayList<GBoard>();
				while (rset.next()) {
					GBoard gb = new GBoard();
					gb.setgBoardNo(rset.getInt("g_board_no"));
					gb.setTitle(rset.getString("title"));
					gb.setContent(rset.getString("content"));
					gb.setUploader(rset.getString("uploader"));
					gb.setStrDate(rset.getString("strdate"));
					gb.setReadcount(rset.getInt("readcount"));
					gb.setAccessNo(rset.getInt("access_no"));
					gb.setGroupNo(rset.getInt("group_no"));
					list.add(gb);
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

	public ArrayList<ShareFile> selectGroupShareFile(Connection con, int groupno) {
		ArrayList<ShareFile> list = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select file_no, title, user_name, content, upload_date, originalfilename, renamefilename, downloadcount"
				+ " from tb_share_file" + " join tb_user on (tb_share_file.uploader=tb_user.user_no)"
				+ " where group_no = ? order by file_no desc";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);

			rset = pstmt.executeQuery();
			if (rset != null) {
				list = new ArrayList<ShareFile>();
				while (rset.next()) {
					ShareFile sf = new ShareFile();
					sf.setFileNo(rset.getInt("file_no"));
					sf.setTitle(rset.getString("title"));
					sf.setUserName(rset.getString("user_name"));
					sf.setContent(rset.getString("content"));
					sf.setUploadDate(rset.getDate("upload_date"));
					sf.setFileName(rset.getString("originalfilename"));
					sf.setRenameFileName(rset.getString("renamefilename"));
					sf.setDownloadCount(rset.getInt("downloadcount"));
					list.add(sf);

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

}
