package com.studyhub.main.board.model.dao;

import static com.studyhub.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.studyhub.common.vo.Board;

public class BoardDao {

	private Board board;

	public int getListCount(Connection con) {
		// 총 게시글 갯수 조회용
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select count(*) from tb_board";

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

	public ArrayList<Board> selectList(Connection con, int currentPage, int limit) {
		// 한 페이지에 출력할 게시글 목록 조회용
		ArrayList<Board> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// currentPage 에 해당되는 목록만 조회
		String query = "select * from (select rownum rnum, board_no, title, user_name, content, upload_date from (select * from tb_board join tb_user on(tb_board.uploader=tb_user.user_no) order by board_no desc)) where rnum >= ? and rnum <= ?";
		/* + "board_original_filename, " */
		/* + "board_rename_filename, " */
		/* + "board_readcount " */

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			if (rset != null) {
				list = new ArrayList<Board>();

				while (rset.next()) {
					Board b = new Board();

					b.setBoardNo(rset.getInt("board_no"));
					b.setTitle(rset.getString("title"));
					b.setUploaderName(rset.getString("user_name"));
					b.setContent(rset.getString("content"));
					b.setUploadDate(rset.getDate("upload_date"));
					// b.setBoardReadCount(rset.getInt("board_readcount"));
					// b.setBoardOriginalFileName(rset.getString("board_original_filename"));
					// b.setBoardRenameFileName(rset.getString("board_rename_filename"));

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

	public int insertBoard(Connection con, Board b) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int addReadCount(Connection con, int bnum) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Board selectBoard(Connection con, int bnum) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteBoard(Connection con, int bnum) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateBoard(Connection con, Board b) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * public int insertBoard(Connection con, Board b) { int result = 0;
	 * PreparedStatement pstmt = null;
	 * 
	 * String query = "insert into board values (" +
	 * "(select max(board_no) + 1 from board), " +
	 * "?, ?, ?, ?, ?, sysdate, default, 0, " +
	 * "(select max(board_no) + 1 from board), NULL, " + "default)";
	 * 
	 * try { pstmt = con.prepareStatement(query); pstmt.setString(1,
	 * b.getBoardTitle()); pstmt.setString(2, b.getBoardWriter());
	 * pstmt.setString(3, b.getBoardContent()); pstmt.setString(4,
	 * b.getBoardOriginalFileName()); pstmt.setString(5,
	 * b.getBoardRenameFileName());
	 * 
	 * result = pstmt.executeUpdate();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { close(pstmt); }
	 * 
	 * return result; }
	 */

	/*
	 * public int addReadCount(Connection con, int bnum) { int result = 0;
	 * PreparedStatement pstmt = null;
	 * 
	 * String query = "update board set " +
	 * "board_readcount = board_readcount + 1 " + "where board_no = ?";
	 * 
	 * try { pstmt = con.prepareStatement(query); pstmt.setInt(1, bnum);
	 * 
	 * result = pstmt.executeUpdate();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { close(pstmt); }
	 * 
	 * return result; }
	 */

	/*
	 * public Board selectBoard(Connection con, int bnum) { Board board = null;
	 * PreparedStatement pstmt = null; ResultSet rset = null;
	 * 
	 * String query = "select * from board where board_no = ?";
	 * 
	 * try { pstmt = con.prepareStatement(query); pstmt.setInt(1, bnum);
	 * 
	 * rset = pstmt.executeQuery();
	 * 
	 * if (rset.next()) { board = new Board();
	 * 
	 * board.setBoardNum(rset.getInt("board_no"));
	 * board.setBoardTitle(rset.getString("board_title"));
	 * board.setBoardWriter(rset.getString("board_writer"));
	 * board.setBoardContent(rset.getString("board_content"));
	 * board.setBoardDate(rset.getDate("board_date"));
	 * board.setBoardReadCount(rset.getInt("board_readcount"));
	 * board.setBoardOriginalFileName(rset.getString("board_original_filename"))
	 * ; board.setBoardRenameFileName(rset.getString("board_rename_filename"));
	 * board.setBoardLevel(rset.getInt("board_level"));
	 * board.setBoardRef(rset.getInt("board_ref"));
	 * board.setBoardReplyRef(rset.getInt("board_reply_ref"));
	 * board.setBoardReplySeq(rset.getInt("board_reply_seq")); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { close(rset);
	 * close(pstmt); }
	 * 
	 * return board; }
	 */

	/*
	 * public int deleteBoard(Connection con, int bnum) { int result = 0;
	 * PreparedStatement pstmt = null;
	 * 
	 * String query = "delete from board where board_no = ?";
	 * 
	 * try { pstmt = con.prepareStatement(query); pstmt.setInt(1, bnum);
	 * 
	 * result = pstmt.executeUpdate();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { close(pstmt); }
	 * 
	 * return result; }
	 * 
	 * public int updateReplySeq(Connection con, Board replyBoard) { int result
	 * = 0; PreparedStatement pstmt = null;
	 * 
	 * String query = "update board set " +
	 * "board_reply_seq = board_reply_seq + 1 " +
	 * "where board_ref = ? and board_level = ? " + "and board_reply_ref = ?";
	 * 
	 * try { pstmt = con.prepareStatement(query); pstmt.setInt(1,
	 * replyBoard.getBoardRef()); pstmt.setInt(2, replyBoard.getBoardLevel());
	 * pstmt.setInt(3, replyBoard.getBoardReplyRef());
	 * 
	 * result = pstmt.executeUpdate();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { close(pstmt); }
	 * 
	 * return result; }
	 * 
	 * public int updateBoard(Connection con, Board b) { int result = 0;
	 * PreparedStatement pstmt = null;
	 * 
	 * String query = "update board set board_title = ?, " +
	 * "board_content = ?, " + "board_original_filename = ?, " +
	 * "board_rename_filename = ? " + "where board_no = ?";
	 * 
	 * try { pstmt = con.prepareStatement(query); pstmt.setString(1,
	 * b.getBoardTitle()); pstmt.setString(2, b.getBoardContent());
	 * pstmt.setString(3, b.getBoardOriginalFileName()); pstmt.setString(4,
	 * b.getBoardRenameFileName()); pstmt.setInt(5, b.getBoardNum());
	 * 
	 * result = pstmt.executeUpdate();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { close(pstmt); }
	 * 
	 * return result; }
	 */

}
