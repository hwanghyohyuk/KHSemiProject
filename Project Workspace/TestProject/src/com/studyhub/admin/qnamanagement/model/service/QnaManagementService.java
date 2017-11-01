package com.studyhub.admin.qnamanagement.model.service;

import static com.studyhub.common.JDBCTemplate.*;
import java.sql.Connection;

import com.studyhub.admin.qnamanagement.model.dao.QnaManagementDao;

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

}
