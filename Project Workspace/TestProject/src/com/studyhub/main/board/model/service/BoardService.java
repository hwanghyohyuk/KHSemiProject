package com.studyhub.main.board.model.service;

import static com.studyhub.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.studyhub.common.vo.Board;
import com.studyhub.main.board.model.dao.BoardDao;

public class BoardService {

	private BoardDao bd;
	private Board board;

	public BoardService() {
	}

	// 전체 게시글 갯수 조회용
	public int getListCount() {
		Connection con = getConnection();
		int listCount = new BoardDao().getListCount(con);
		close(con);
		return listCount;
	}

	// 페이지별 목록 조회용
	public ArrayList<Board> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<Board> list = new BoardDao().selectList(con, currentPage, limit);
		close(con);
		return list;
	}

	public int insertBoard(Board b) {
		Connection con = getConnection();
		int result = new BoardDao().insertBoard(con, b);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public void addReadCount(int bnum) {
		Connection con = getConnection();
		int result = new BoardDao().addReadCount(con, bnum);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return;
	}

	public Board selectBoard(int bnum) {
		Connection con = getConnection();
		Board board = new BoardDao().selectBoard(con, bnum);
		close(con);
		return board;
	}

	public int deleteBoard(int bnum) {
		Connection con = getConnection();
		int result = new BoardDao().deleteBoard(con, bnum);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int updateBoard(Board b) {
		Connection con = getConnection();
		int result = new BoardDao().updateBoard(con, b);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

}
