package com.studyhub.group.qna.model.service;

import static com.studyhub.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.studyhub.common.vo.GQComment;
import com.studyhub.common.vo.GQNA;
import com.studyhub.group.qna.model.dao.GroupQnADao;

public class GroupQnAService {

	public int InsertQnA(int userno, int groupno, String title, String content) {
		Connection con = getConnection();
		int result = new GroupQnADao().InsertQnA(con, userno, groupno, title, content);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);		
		return result;
	}
	
	public ArrayList<GQNA> selectGroupQnA(int groupno, int startpage, int endpage) {
		Connection con = getConnection();
		ArrayList<GQNA> list = new GroupQnADao().selectGroupQnA(con, groupno, startpage, endpage);
		close(con);
		return list;
	}

	public int deleteGroupQnA(int gqnano) {
		Connection con = getConnection();
		int result = new GroupQnADao().deleteGroupQnA(con, gqnano);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public ArrayList<GQNA> GroupQnASelectOne(int gqnano) {
		Connection con = getConnection();
		ArrayList<GQNA> list = new GroupQnADao().GroupQnASelectOne(con, gqnano);
		close(con);
		return list;
	}

	public int UpdateGroupQnA(int gqnano, String title, String content) {
		Connection con = getConnection();
		int result = new GroupQnADao().UpdateGroupQnA(con, gqnano, title, content);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public ArrayList<Integer> GroupNoList(int groupno, String searchdata) {
		Connection con = getConnection();
		ArrayList<Integer> groupnolist = new GroupQnADao().GroupNoList(con, groupno, searchdata);
		close(con);
		return groupnolist;
	}

	public ArrayList<GQNA> GQNAlist(int groupno, ArrayList<Integer> groupnolist) {
		Connection con = getConnection();
		ArrayList<GQNA> qnalist = new GroupQnADao().GQNAList(con, groupno, groupnolist);
		close(con);
		return qnalist;
	}

	public ArrayList<GQComment> SelectComment(int gqnano) {
		Connection con = getConnection();
		ArrayList<GQComment> list = new GroupQnADao().SelectComment(con, gqnano);
		close(con);
		return list;
	}

	public int DeleteComment(int commentno) {
		Connection con = getConnection();
		int result = new GroupQnADao().DeleteComment(con, commentno);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int InsertComment(int gqnano, int userno, String content) {
		Connection con = getConnection();
		int result = new GroupQnADao().InsetComment(con, gqnano, userno, content);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

}
