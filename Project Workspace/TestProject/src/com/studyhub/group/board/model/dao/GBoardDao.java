package com.studyhub.group.board.model.dao;

import static com.studyhub.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.studyhub.common.vo.GBoard;
import com.studyhub.group.board.model.service.GBoardService;


public class GBoardDao {
	private GBoard gBoard;

	public GBoardDao() {
	}

	public GBoard selectOne(Connection conn, int no) {
		GBoard gBoard = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from tb_g_board where g_board_no = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				gBoard = new GBoard();
				gBoard.setgBoardNo(rset.getInt("notice_no"));
				gBoard.setTitle(rset.getString("title"));
				gBoard.setContent(rset.getString("content"));
				gBoard.setUploadDate(rset.getDate("upload_date"));
				gBoard.setUploader(rset.getInt("uploader"));
				gBoard.setAccessNo(rset.getInt("access_no"));
				gBoard.setGroupNo(rset.getInt("group_no"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return gBoard;
	}

	public int insertGNotice(Connection conn, GBoard gBoard) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "insert into tb_g_board values ((select max(g_board_no)+1 from tb_g_board),"
				+ " ?, ?, sysdate, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, gBoard.getTitle());
			pstmt.setString(2, gBoard.getContent());
			pstmt.setInt(3, gBoard.getUploader());
			pstmt.setInt(4, gBoard.getAccessNo());
			pstmt.setInt(5, gBoard.getGroupNo());
			
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

		String query = "delete from gboard where g_Board_no = ?";

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
	public int updateGNotice(Connection con, GBoard gBoard) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, gBoard.getTitle());
			pstmt.setString(2, gBoard.getContent());
			pstmt.setInt(3, gBoard.getgBoardNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}

	
	/*// GNotice Comment
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
*/


	

}
