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

		String query = "select group_no ,group_name, attribute_name, location, category_name, description, authority_no, group_state"
				+ " from tb_group" + " join tb_on_off using(attribute_no)" + " join tb_category using(category_no)"
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
				group.setGroupState(rset.getInt("group_state"));
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
	
	


	public ArrayList<GBoard> selectGroupBoard(Connection con, int groupno) {
		ArrayList<GBoard> list = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select rownum, title, content, uploader, upload_date, user_name, access_no, access_right"
				+ "from("
				+ "select * from tb_g_board "
				+ "join tb_user on(tb_user.user_no=tb_g_board.uploader)"
				+ "join tb_access using(access_no) where group_no = ? order by g_board_no asc) "
				+ "where rownum >= ? and rownum<= ? order by rownum desc";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			pstmt.setInt(2, groupno);
			pstmt.setInt(3, groupno);
			// 수정

			rset = pstmt.executeQuery();
			if (rset != null) {
				list = new ArrayList<GBoard>();
				while (rset.next()) {
					GBoard gb = new GBoard();
					gb.setgBoardNo(rset.getInt("g_board_no"));
					gb.setTitle(rset.getString("title"));
					gb.setContent(rset.getString("content"));
					gb.setUploadDate(rset.getDate("upload_date"));
					gb.setUploader(rset.getInt("uploader"));
					gb.setAccessNo(rset.getInt("access_no"));
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

	public int GroupOut(Connection con, int userno, int groupno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "update tb_ung set ung_state = 1 where user_no = ? and group_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userno);
			pstmt.setInt(2, groupno);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int RemoveGroup(Connection con, int groupno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "update tb_group set group_state = 2, delete_date = sysdate + 7 where group_no = ? ";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int RemoveCancel(Connection con, int groupno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "update tb_group set group_state = 0 where group_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<GQNA> top3qna(Connection con, int groupno) {
		ArrayList<GQNA> list = null;
			
		PreparedStatement pstmt = null;
		ResultSet rset = null;
			
		String query = "select g_qna_no, title, user_name, strdate from ("
					+ "select rownum as rnum, g_qna_no, title, user_name, to_char(upload_date, 'yyyy-MM-dd') as strdate "
					+ "from tb_g_qna "
					+ "join tb_user on (uploader=user_no) "
					+ "where group_no = ? "
					+ "order by g_qna_no desc) "
					+ "where rnum < 4";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			
			rset = pstmt.executeQuery();
			if(rset != null) {
				list = new ArrayList<GQNA>();
				while(rset.next()) {
					GQNA gq = new GQNA();
					gq.setgQnaNo(rset.getInt("g_qna_no"));
					gq.setTitle(rset.getString("title"));
					gq.setUploader_name(rset.getString("user_name"));
					gq.setStrDate(rset.getString("strdate"));
					
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

	public ArrayList<GNotice> top5notice(Connection con, int groupno) {
		ArrayList<GNotice> list = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
			
		String query = "select notice_no, title, user_name, strdate from ("
					+ "select rownum as rnum, notice_no, title, user_name, to_char(upload_date, 'yyyy-MM-dd') as strdate "
					+ "from tb_g_notice "
					+ "join tb_user on (uploader=user_no) "
					+ "where group_no = ? "
					+ "order by notice_no desc) "
					+ "where rnum < 6";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			
			rset = pstmt.executeQuery();
			if(rset != null) {
				list = new ArrayList<GNotice>();
				while(rset.next()) {
					GNotice nt = new GNotice();
					nt.setNoticeNo(rset.getInt("notice_no"));
					nt.setTitle(rset.getString("title"));
					nt.setUploader_name(rset.getString("user_name"));
					nt.setStrDate(rset.getString("strdate"));
					
					list.add(nt);
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
	
	public ArrayList<Schedule> top5schedule(Connection con, int groupno) {
		ArrayList<Schedule> list = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
			
		String query = "select schedule_no, meeting_date, ampm, hour, minute, meeting_name  from ("
					+ "select rownum as rnum, schedule_no, meeting_date, ampm, hour, minute, meeting_name "
					+ "from tb_schedule "
					+ "where group_no = ? "
					+ "order by datetypedate asc) "
					+ "where rnum < 6";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			
			rset = pstmt.executeQuery();
			if(rset != null) {
				list = new ArrayList<Schedule>();
				while(rset.next()) {
					Schedule sc = new Schedule();
					sc.setScheduleNo(rset.getInt("schedule_no"));
					sc.setMeetingDate(rset.getString("meeting_date"));
					sc.setAmpm(rset.getString("ampm"));
					sc.setHour(rset.getString("hour"));
					sc.setMinute(rset.getString("minute"));
					sc.setMeetingName(rset.getString("meeting_name"));
					
					list.add(sc);
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

	public ArrayList<GBoard> top3board(Connection con, int groupno) {
		ArrayList<GBoard> list = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
			
		String query = "select g_board_no, title, user_name, strdate from ("
					+ "select rownum as rnum, g_board_no, title, user_name, to_char(upload_date, 'yyyy-MM-dd') as strdate "
					+ "from tb_g_board "
					+ "join tb_user on (uploader=user_no) "
					+ "where group_no = ? "
					+ "order by readcount desc) "
					+ "where rnum < 4";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			
			rset = pstmt.executeQuery();
			if(rset != null) {
				list = new ArrayList<GBoard>();
				while(rset.next()) {
					GBoard b = new GBoard();
					b.setgBoardNo(rset.getInt("g_board_no"));
					b.setTitle(rset.getString("title"));
					b.setUploaderName(rset.getString("user_name"));
					b.setStrDate(rset.getString("strdate"));
					
					list.add(b);
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

	public ArrayList<ShareFile> top3sharefile(Connection con, int groupno) {
		ArrayList<ShareFile> list = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
			
		String query = "select file_no, title, user_name, strdate from ("
					+ "select rownum as rnum, file_no, title, user_name, to_char(upload_date, 'yyyy-MM-dd') as strdate "
					+ "from tb_share_file "
					+ "join tb_user on (uploader=user_no) "
					+ "where group_no = ? "
					+ "order by downloadcount desc) "
					+ "where rnum < 4";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			
			rset = pstmt.executeQuery();
			if(rset != null) {
				list = new ArrayList<ShareFile>();
				while(rset.next()) {
					ShareFile sf = new ShareFile();
					sf.setFileNo(rset.getInt("file_no"));
					sf.setTitle(rset.getString("title"));
					sf.setUserName(rset.getString("user_name"));
					sf.setStrDate(rset.getString("strdate"));
					
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
