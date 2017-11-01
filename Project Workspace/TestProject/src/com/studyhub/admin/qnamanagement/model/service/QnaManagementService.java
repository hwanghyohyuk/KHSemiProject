package com.studyhub.admin.qnamanagement.model.service;

import static com.studyhub.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.studyhub.admin.qnamanagement.model.dao.QnaManagementDao;
import com.studyhub.common.vo.GQNA;
import com.studyhub.common.vo.QnA;
import com.studyhub.group.qna.model.dao.GroupQnADao;

public class QnaManagementService {

	public int DeleteQna(int qnano) {
		Connection con = getConnection();
		int result = new QnaManagementDao().DeleteQna(con, qnano);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public ArrayList<Integer> QnaNoList(String search) {
		Connection con = getConnection();
		ArrayList<Integer> qnanolist = new QnaManagementDao().QnaNoList(con, search);
		close(con);
		return qnanolist;
	}

	public ArrayList<QnA> QNAlist(ArrayList<Integer> qnanolist) {
		Connection con = getConnection();
		ArrayList<QnA> qnalist = new QnaManagementDao().QNAList(con, qnanolist);
		close(con);
		return qnalist;
	}

}
