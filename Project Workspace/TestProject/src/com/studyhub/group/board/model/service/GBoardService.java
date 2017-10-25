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

	private GBoard gNboard;
	private GBoardDao gNboardDao;

	public GBoardService() {
	}

	// 원글 삭제 처리용
	public int deleteBoard(int bnum) {
		Connection con = getConnection();
		int result = new GBoardDao().deleteBoard(con, bnum);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	// 원글 등록 처리용
	public int insertBoard(GBoard b) {
		Connection con = getConnection();
		int result = new GBoardDao().insertBoard(con, b);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	// 페이지별 목록 조회용
	public ArrayList<GBoard> selectList(int currentPage, int limit, int no) {
		Connection con = getConnection();
		ArrayList<GBoard> list = new GBoardDao().selectList(con, limit, no);
		close(con);
		return list;
	}
	
	//원글 검색용
	public GBoard searchBoard(int bnum) {
		Connection con = getConnection();
		GBoard board = new GBoardDao().searchBoard(con, bnum);
		close(con);
		return board;
	}
	
	//원글 수정용
	public int updateBoard(GBoard b) {
		Connection con = getConnection();
		int result = new GBoardDao().updateBoard(con, b);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	//원글 수정 참조용
	public int updateViewBoard(GBoard b) {
		Connection con = getConnection();
		int result = new GBoardDao().updateViewBoard(con, b);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	//원글 참조용
	public int viewBoard(GBoard b) {
		Connection con = getConnection();
		int result = new GBoardDao().viewBoard(con, b);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	//전체 게시글 갯수 조회용
	public int getListCount(){
		Connection con = getConnection();
		int listCount = new GBoardDao().ListCount(con);
		close(con);
		return listCount;
	}


	

}
