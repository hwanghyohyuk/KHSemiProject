package com.studyhub.group.board.model.dao;

import static com.studyhub.common.JDBCTemplate.*;
import java.sql.*;
import java.util.ArrayList;

import com.studyhub.common.vo.GBComment;
import com.studyhub.common.vo.GBoard;

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
				gBoard.setgBoardNo(rset.getInt("gboard_no"));
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

	public int insertGBoard(Connection conn, GBoard gBoard) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "insert into tb_g_board values ((select max(g_board_no)+1 from tb_g_board),"
				+ " ?, ?,  sysdate, ? , ?, ?, 0)";
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

	public int deleteBoard(Connection conn, int bnum) {
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

	public int updateGboard(Connection con, GBoard gBoard) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update tb_g_board set title = ?, content = ? " + "where g_board_no = ?";

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

	public int getListCount(Connection con) {
		// 총 게시글 갯수 조회용
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select count(*) from tb_g_board";

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next())
				result = rset.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return result;
	}

	public ArrayList<GBoard> selectList(Connection con, int groupno, int currentPage, int limit) {
		// 한 페이지에 출력할 게시글 목록 조회용
		ArrayList<GBoard> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// currentPage 에 해당되는 목록만 조회
		String query = "select rownum, g_board_no, title, content, uploader, upload_date, user_name, access_no, access_right "
				+ "from(select * from tb_g_board " + "join tb_user on(tb_user.user_no=tb_g_board.uploader) "
				+ "join tb_access using(access_no) where group_no = ? order by g_board_no asc) "
				+ "where rownum >= ? and rownum<= ? order by rownum desc";

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			if (rset != null) {
				list = new ArrayList<GBoard>();

				while (rset.next()) {
					GBoard gb = new GBoard();

					gb.setRownum(rset.getInt("rownum"));
					gb.setgBoardNo(rset.getInt("g_board_no"));
					gb.setTitle(rset.getString("title"));
					gb.setContent(rset.getString("content"));
					gb.setUploader(rset.getInt("uploader"));
					gb.setUploaderName(rset.getString("user_name"));
					gb.setUploadDate(rset.getDate("upload_date"));
					gb.setAccessNo(rset.getInt("access_no"));
					gb.setAccessRight(rset.getString("access_right"));

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

	
	public int deleteComment(Connection con, int cno) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "delete from tb_gboard_comment where comment_no =? ";

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

	public int insertComment(Connection con, int gboardno, String comment, int userno) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, gboardno);
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

	public ArrayList<GBComment> selectComment(Connection con, int gboardno) {
		ArrayList<GBComment> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, gboardno);

			rset = pstmt.executeQuery();
			if (rset != null) {
				list = new ArrayList<GBComment>();
				while (rset.next()) {
					GBComment gnc = new GBComment();
					gnc.setCommentNo(rset.getInt("comment_no"));
					gnc.setgBoardNo(rset.getInt("gboard_no"));
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
