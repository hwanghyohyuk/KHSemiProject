package com.studyhub.main.board.model.service;

import static com.studyhub.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.studyhub.common.vo.Board;
import com.studyhub.common.vo.Group;
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
	
	//검색 목록 조회용
	public ArrayList<Board> selectList(int currentPage, int limit, String keyword) {
		Connection con = getConnection();
		ArrayList<Board> list = new BoardDao().selectList(con, currentPage, limit, keyword);
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

	public Board selectBoard(int bno) {
		Connection con = getConnection();
		Board board = new BoardDao().selectBoard(con, bno);
		close(con);
		return board;
	}

	public int deleteBoard(int bno) {
		Connection con = getConnection();
		int result = new BoardDao().deleteBoard(con, bno);
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

	public ArrayList<Group> selectGroupList(int userno) {
		Connection con = getConnection();
		ArrayList<Group> list = new BoardDao().selectGroupList(con, userno);
		close(con);
		return list;
	}

	public int getGroupCount() {
		Connection con = getConnection();
		int groupCount = new BoardDao().getGroupCount(con);
		close(con);
		return groupCount;
	}

	public ArrayList<Board> top5board() {
		Connection con = getConnection();
		ArrayList<Board> list = new BoardDao().top5board(con);
		close(con);
		return list;
	}

	

}
