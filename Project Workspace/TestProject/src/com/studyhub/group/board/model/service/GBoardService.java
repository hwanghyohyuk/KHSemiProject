package com.studyhub.group.board.model.service;

import static com.studyhub.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.studyhub.common.vo.GBComment;
import com.studyhub.common.vo.GBoard;
import com.studyhub.group.board.model.dao.GBoardDao;

public class GBoardService {

	private GBoard gBoard;
	private GBoardDao gbDao;

	public GBoardService() {
	}

	// GNotice

	public GBoard selectGBoard(int no) {
		Connection conn = getConnection();
		GBoard gBoard = new GBoardDao().selectOne(conn, no);
		return gBoard;
	}

	public int insertGBoard(GBoard gBoard) {
		Connection conn = getConnection();
		int result = new GBoardDao().insertGBoard(conn, gBoard);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		return result;

	}

	public int deleteGBoard(int bno) {
		Connection conn = getConnection();
		int result = new GBoardDao().deleteBoard(conn, bno);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updateGBoard(GBoard gBoard) {
		Connection con = getConnection();
		int result = new GBoardDao().updateGboard(con, gBoard);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int getListCount() {
		Connection con = getConnection();
		gbDao = new GBoardDao();
		int listCount = gbDao.getListCount(con);
		close(con);
		return listCount;
	}

	public ArrayList<GBoard> selectList(int groupno, int currentPage, int limit) {
		Connection con = getConnection();
		gbDao = new GBoardDao();
		ArrayList<GBoard> list = gbDao.selectList(con, groupno, currentPage, limit);
		close(con);
		return list;
	}

	
	
	
	public int deleteComment(int cno) {
		Connection con = getConnection();
		int result = new GBoardDao().deleteComment(con, cno);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;

	}

	public int insertComment(int gboardno, int uploader, String comment) {
		Connection con = getConnection();
		int result = new GBoardDao().insertComment(con, gboardno,uploader, comment);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public ArrayList<GBComment> selectcomment(int gboardno) {
		Connection con = getConnection();
		ArrayList<GBComment> list = new GBoardDao().selectComment(con, gboardno);
		close(con);

		return list;
	}

}
