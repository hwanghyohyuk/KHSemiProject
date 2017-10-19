package com.studyhub.group.board.model.dao;

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
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertBoard(Connection con, GBoard b) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<GBoard> selectList(Connection con, int currentPage, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public GBoard searchBoard(Connection con, int bnum) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateBoard(Connection con, GBoard b) {
		// TODO Auto-generated method stub
		return 0;
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
