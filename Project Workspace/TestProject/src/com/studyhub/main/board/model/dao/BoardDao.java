package com.studyhub.main.board.model.dao;

import static com.studyhub.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.studyhub.common.vo.Board;
import com.studyhub.common.vo.Group;
import com.studyhub.common.vo.QnA;

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
		ArrayList<Board> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from("
				+ "select rownum rnum, board_no, title, user_name, content, upload_date, deadline_date, "
				+ "case when deadline_date > sysdate then '모집중' " + "else '마감' end as status "
				+ ", group_name, location, category_name, attribute_name, g_img_rename, memberCount " + "from "
				+ "(select * " + "from tb_board " + "join tb_user on (tb_board.uploader=tb_user.user_no) "
				+ "join tb_ung using(user_no) " + "join tb_group using(group_no) "
				+ "join tb_on_off using(attribute_no) " + "join tb_category using(category_no) "
				+ "join (select group_no, count(*) as memberCount " + "from tb_ung group by group_no) using(group_no) "
				+ "where authority_no=(select authority_no "
				+ "from tb_authority where authority_name='그룹장') and job_group=group_no "
				+ "order by board_no desc)) where rnum >= ? and rnum <= ?";

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

	public int insertBoard(Connection con, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "insert into tb_board values (" + "(select max(board_no) + 1 from board), "
				+ "?, ?, ?, ?, ?, sysdate, default, 0, " + "(select max(board_no) + 1 from board), NULL, " + "default)";

		return result;
	}

	public int addReadCount(Connection con, int bnum) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Board selectBoard(Connection con, int bno) {
		board = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select board_no, title, content, upload_date, user_name " + "from tb_board "
				+ "join tb_user on (tb_board.uploader = tb_user.user_no) " + "where board_no = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bno);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				board = new Board();
				board.setBoardNo(rset.getInt("board_no"));
				board.setTitle(rset.getString("title"));
				board.setContent(rset.getString("content"));
				// board.setUploadDate(rset.getDate("upload_date"));
				board.setUploaderName(rset.getString("user_name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return board;
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
		
		String query = "select tb_group.group_no, group_name from tb_board "
				+ "join tb_group on(tb_group.group_no=tb_board.job_group) "
				+ "join tb_ung on(tb_ung.group_no=tb_board.job_group) "
				+ "where deadline_date<sysdate and uploader = ? "
				+ "and authority_no = (select authority_no "
				+ "from tb_authority where authority_name='그룹장')";

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
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;		
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
