package com.studyhub.main.model.service;

import static com.studyhub.common.JDBCTemplate.close;
import static com.studyhub.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.studyhub.common.vo.Board;
import com.studyhub.common.vo.Group;
import com.studyhub.common.vo.UNG;
import com.studyhub.group.main.model.dao.GMainDao;
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

}
