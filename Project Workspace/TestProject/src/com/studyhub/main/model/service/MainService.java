package com.studyhub.main.model.service;

import static com.studyhub.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.studyhub.common.vo.Board;
import com.studyhub.common.vo.Category;
import com.studyhub.common.vo.Group;
import com.studyhub.common.vo.Message;
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

	public int inserUnG(int userNo, int groupNo, int authorityNo, int ungState) {
		Connection con = getConnection();
		int result = new MainDao().insertUnG(con, userNo, groupNo, authorityNo, ungState);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int selectGroupNo(String groupname) {
		Connection con = getConnection();
		int groupNo = new MainDao().selectGroupNo(con, groupname);
		close(con);
		return groupNo;
	}

	public int countGroup(String userEmail) {
		Connection con = getConnection();
		int result = new MainDao().countGroup(con, userEmail);
		close(con);
		return result;
	}

	public int MessageCount(int userno) {
		Connection con = getConnection();
		int result = new MainDao().MessageCount(con, userno);
		close(con);
		return result;
	}

	public ArrayList<Message> MessageSelect(int userno) {
		Connection con = getConnection();
		ArrayList<Message> list = new MainDao().MessageSelect(con, userno);
		close(con);
		return list;
	}

	public int InviteAgree(int groupno, int receiver) {
		Connection con = getConnection();
		int result = new MainDao().InviteAgree(con, groupno, receiver);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int changeMessage1(int messageno) {
		Connection con = getConnection();
		int result = new MainDao().changeMessage1(con, messageno);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int InsertMessage(int groupno, int sender, int receiver) {
		Connection con = getConnection();
		int result = new MainDao().InsertMessage(con, groupno, sender, receiver);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int InsertMessage2(int groupno, int sender, int receiver) {
		Connection con = getConnection();
		int result = new MainDao().InsertMessage2(con, groupno, sender, receiver);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}
	
	public int InsertMessage3(int groupno, int sender, int receiver) {
		Connection con = getConnection();
		int result = new MainDao().InsertMessage3(con, groupno, sender, receiver);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int ungState(int senderNo, int groupNo) {
		Connection con = getConnection();
		int result = new MainDao().ungState(con, senderNo, groupNo);
		close(con);
		return result;
	}

	public ArrayList<Category> selectCategoryList() {
		Connection con = getConnection();
		ArrayList<Category> list = new MainDao().selectCategoryList(con);
		close(con);
		return list;
	}

	public ArrayList<Group> selectGroupList() {
		Connection con = getConnection();
		ArrayList<Group> list = new MainDao().selectGroupList(con);
		close(con);
		return list;
	}

	public ArrayList<Group> searchGroupList(int attrNo, int cateNo, String location, String keyword) {
		Connection con = getConnection();
		ArrayList<Group> list = new MainDao().searchGroupList(con, attrNo, cateNo, location, keyword);
		close(con);
		return list;
	}

}
