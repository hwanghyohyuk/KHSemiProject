package com.studyhub.main.model.service;

import static com.studyhub.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.studyhub.common.vo.Board;

import com.studyhub.common.vo.Group;
import com.studyhub.common.vo.UNG;
import com.studyhub.main.model.dao.MainDao;

public class MainService {

	private MainDao md;
	private UNG ung;
	private Group group;
	private Board board;

	public ArrayList<UNG> selectJoinGroup(int userno) {
		Connection con = getConnection();
		ArrayList<UNG> list = new MainDao().selectJoinGroup(con, userno);
		close(con);
		return list;
	}

	public int insertGroup(Group g) {
		Connection con = getConnection();
		int result = new MainDao().InsertGroup(con, g);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int inserUnG(int userno, Group groupno) {
		Connection con = getConnection();
		int result = new MainDao().InsertUnG(con, userno, groupno);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public Group selectGroupNo(String groupname) {
		Connection con = getConnection();
		Group group = new MainDao().selectGroupNo(con, groupname);
		close(con);
		return group;
	}

	public int countGroup(String userEmail) {
		Connection con = getConnection();
		int result = new MainDao().countGroup(con, userEmail);
		close(con);
		return result;
	}
}
