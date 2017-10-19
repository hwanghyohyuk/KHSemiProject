package com.studyhub.group.qna.model.service;

import static com.studyhub.common.JDBCTemplate.*;

import java.sql.Connection;

import com.studyhub.group.qna.model.dao.QnADao;

public class QnAService {

	public int InsertQnA(int userno, int groupno, String title, String content) {
		Connection con = getConnection();
		int result = new QnADao().InsertQnA(con, userno, groupno, title, content);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);		
		return result;
	}

}
