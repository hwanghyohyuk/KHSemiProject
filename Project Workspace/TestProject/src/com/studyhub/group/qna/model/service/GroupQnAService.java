package com.studyhub.group.qna.model.service;

import static com.studyhub.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

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
	
	public ArrayList<GQNA> selectGroupQnA(int groupno) {
		Connection con = getConnection();
		ArrayList<GQNA> list = new GroupQnADao().selectGroupQnA(con, groupno);
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
		return 0;
	}

}
