package com.studyhub.main.board.model.dao;

import static com.studyhub.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.studyhub.common.vo.Board;
import com.studyhub.common.vo.Group;
import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.RSAKeyValueResolver;

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
	
	public ArrayList<Board> selectList(Connection con, int currentPage, int limit, String keyword) {
		ArrayList<Board> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from boardlistview where board_no in "
				+ "(select distinct board_no from "
				+ "(select board_no, decode(filter,1,title,2,user_name,3,content,4,status,5,group_name,6,location,7,category_name,8,attribute_name) as data "
				+ "from boardlistview,(select level as filter from dual connect by level<=8)) where LOWER(data) like LOWER(?) ) and rnum >= ? and rnum <= ? "
				+ "order by board_no desc";

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

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
				b.setGroupNo(rset.getInt("group_no"));
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

	public int deleteBoard(Connection con, int bno) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "delete from tb_board where board_no = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateBoard(Connection con, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update tb_board set title=?, content=?, upload_date=sysdate, deadline_date=?, job_group=? "
				+ "where board_no=?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setDate(3, b.getDeadlineDate());
			pstmt.setInt(4, b.getGroupNo());
			pstmt.setInt(5, b.getBoardNo());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Group> selectGroupList(Connection con, int userNo) {
		ArrayList<Group> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		
		String query = "select group_no, group_name"
				+ " from boardlistview"
				+ " where user_name = (select user_name from tb_user where user_no = ?) and"
				+ " group_name not in (select group_name from boardlistview where status = '모집중')";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);

			rset = pstmt.executeQuery();
			list = new ArrayList<Group>();
			if (rset != null) {

				while (rset.next()) {
					Group g = new Group();
					g.setGroupNo(rset.getInt("group_no"));
					g.setGroupName(rset.getString("group_name"));

					list.add(g);
					System.out.println("g : "+g);
				}
			}else{
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

	public ArrayList<Board> top5board(Connection con) {
		ArrayList<Board> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from boardlistview "
				+ "where status = '모집중' and (rnum<=(select max(rnum) from boardlistview) "
				+ "and rnum>=(select max(rnum)-4 from boardlistview)) ";
	
		try {
			pstmt = con.prepareStatement(query);
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
}