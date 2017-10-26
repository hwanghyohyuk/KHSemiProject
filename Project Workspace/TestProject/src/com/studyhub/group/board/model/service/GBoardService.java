package com.studyhub.group.board.model.service;

import static com.studyhub.common.JDBCTemplate.close;
import static com.studyhub.common.JDBCTemplate.commit;
import static com.studyhub.common.JDBCTemplate.getConnection;
import static com.studyhub.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.studyhub.common.vo.GBoard;
import com.studyhub.group.board.model.dao.GBoardDao;


public class GBoardService {

	private GBoard gBoard;
	private GBoardDao gNoticeDao;
	
	public GBoardService(){}
	
	//GNotice
		
	public GBoard selectGBoard(int no){
		Connection conn = getConnection();
		GBoard gBoard = new GBoardDao().selectOne(conn, no);
		return gBoard;
	}
		
	
	public int insertGBoard(GBoard gBoard){
		Connection conn = getConnection();
		int result = new GBoardDao().insertGNotice(conn, gBoard);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		return result;
		
	}	
	

	public int deleteGBoard(int bnum) {
		Connection conn = getConnection();
		int result = new GBoardDao().deleteNotice(conn, bnum);
		if(result >0 )
			commit(conn);
		else
			rollback(conn);
		close(conn);		
		return result;
	}
	
	public int updateGBoard(GBoard gBoard) {
		Connection con = getConnection();
		int result = new GBoardDao().updateGNotice(con, gBoard);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	
	
	/*// GNoticeComment

	public int deleteComment(int cno) {
		Connection con = getConnection();
		int result = new GNoticeDao().deleteComment(con, cno);
		if(result >0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
		
	}

	public int insertComment(int gnoticeno, String comment, int userno) {
		Connection con = getConnection();
		int result = new GNoticeDao().insertComment(con, gnoticeno, comment, userno);
		if(result>0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public ArrayList<GNComment> selectcomment(int gnoticeno) {
		Connection con = getConnection();
		ArrayList<GNComment> list = new GNoticeDao().selectComment(con, gnoticeno);
		close(con);
		
		return list;
	}*/


	

}
