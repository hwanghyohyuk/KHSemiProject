package com.studyhub.main.board.model.dao;

import static com.studyhub.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.studyhub.common.vo.Board;
import com.studyhub.common.vo.Group;

public class BoardDao {

	private Board b;

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
		ArrayList<Board> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from boardlistview "
				+ "where rnum >= ? and rnum <= ?";

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
					b.setUploader(rset.getInt("user_no"));
					b.setUploaderName(rset.getString("user_name"));
					b.setContent(rset.getString("content"));
					b.setUploadDate(rset.getDate("upload_date"));
					b.setDeadlineDate(rset.getDate("deadline_date"));
					b.setStatus(rset.getString("status"));
					b.setGroupName(rset.getString("group_name"));
					b.setLocation(rset.getString("location"));
					b.setCategoryName(rset.getString("category_name"));
					b.setAttributeName(rset.getString("attribute_name"));
					b.setgImgRename(rset.getString("g_img_rename"));
					b.setMemberCount(rset.getInt("memberCount"));

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
	
	public Board selectBoard(Connection con, int bno) {
		b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from boardlistview "
				+ "where board_no = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bno);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				b = new Board();
				b.setBoardNo(rset.getInt("board_no"));
				b.setTitle(rset.getString("title"));
				b.setUploader(rset.getInt("user_no"));
				b.setUploaderName(rset.getString("user_name"));
				b.setContent(rset.getString("content"));
				b.setUploadDate(rset.getDate("upload_date"));
				b.setDeadlineDate(rset.getDate("deadline_date"));
				b.setStatus(rset.getString("status"));
				b.setGroupName(rset.getString("group_name"));
				b.setLocation(rset.getString("location"));
				b.setCategoryName(rset.getString("category_name"));
				b.setAttributeName(rset.getString("attribute_name"));
				b.setgImgRename(rset.getString("g_img_rename"));
				b.setMemberCount(rset.getInt("memberCount"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return b;
	}

	public int insertBoard(Connection con, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "insert into tb_board values ((select max(board_no) + 1 from tb_board), "
				+ "?, ?, sysdate, ?, ?, ?)";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setDate(3, b.getDeadlineDate());
			pstmt.setInt(4, b.getUploader());
			pstmt.setInt(5, b.getGroupNo());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int addReadCount(Connection con, int bnum) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	public int deleteBoard(Connection con, int bnum) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateBoard(Connection con, Board b) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Group> selectGroupList(Connection con, int userNo) {
		ArrayList<Group> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		
		String query = "select group_no, group_name "
				+ "from boardlistview "
				+ "where user_name = (select user_name from tb_user where user_no = ?) and "
				+ "group_name not in (select group_name from boardlistview where status = '모집중')";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);

			rset = pstmt.executeQuery();

			if (rset != null) {
				list = new ArrayList<Group>();

				while (rset.next()) {
					Group g = new Group();
					g.setGroupNo(rset.getInt("group_no"));
					g.setGroupName(rset.getString("group_name"));

					list.add(g);
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

	public int getGroupCount(Connection con) {
		// 모집 그룹 수 조회용
				int result = 0;
				Statement stmt = null;
				ResultSet rset = null;

				String query = "select count(*) from boardlistview where status = '모집중'";

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
