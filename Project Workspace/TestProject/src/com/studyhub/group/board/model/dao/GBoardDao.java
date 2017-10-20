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

	private GBoard gNboard;

	public int deleteBoard(Connection con, int bnum) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from gboard where gboard_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bnum);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	public int insertBoard(Connection con, GBoard b) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into gboard values ("
				+ "(select max(gboard_no) + 1 from gboard), "
				+ "?, ?, ?, ?, ?, sysdate, default, 0, "
				+ "(select max(gboard_no) + 1 from gboard), NULL, "
				+ "default)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getUploader());
			pstmt.setString(3, b.getContent());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<GBoard> selectList(Connection con, int currentPage, int limit){
			
			ArrayList<GBoard> list = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query ="select * from ("
					+ "select rownum rnum, gboard_no, gboard_title, "
					+ "gboard_uploader, gboard_content, gboard_original_filename, "
					+ "gboard_rename_filename, gboard_date, gboard_level, "
					+ "gboard_readcount from (select * from gboard "
					+ "order by gboard_ref desc, gboard_reply_ref desc, "
					+ "gboard_level asc, gboard_reply_seq asc)) "
					+ "where rnum >= ? and rnum <= ?";
			
			int startRow = (currentPage -1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rset = pstmt.executeQuery();
				
				if(rset != null){
					list = new ArrayList<GBoard>();
					
					while(rset.next()){
						GBoard b = new GBoard();
						
						b.setgBoardNo(rset.getInt("gboard_no"));
						b.setTitle(rset.getString("gboard_title"));
						b.setUploader(rset.getString("gboard_uploader"));
						b.setContent(rset.getString("gboard_content"));
						b.setUploadDate(rset.getDate("gboard_uploaderdate"));
						
						list.add(b);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				close(rset);
				close(pstmt);
			}
			
			return list;
	}
	

	public GBoard searchBoard(Connection con, int bnum) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateBoard(Connection con, GBoard b) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update gboard set gboard_title = ?, "
				+ "gboard_content = ?, "
				+ "gboard_original_filename = ?, "
				+ "gboard_rename_filename = ? "
				+ "where gboard_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getgBoardNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	public int updateViewBoard(Connection con, GBoard b) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int viewBoard(Connection con, GBoard b) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int ListCount(Connection con) {
		// TODO Auto-generated method stub
		return 0;
	}

}
