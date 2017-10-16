package com.studyhub.main.qna.model.dao;

import java.util.ArrayList;
import java.sql.*;


import com.studyhub.common.vo.QnA;
import com.studyhub.common.vo.QComment;
import com.studyhub.common.JDBCTemplate.*;

public class QnADao {
	public QnADao() {
	}

	public ArrayList<QnA> selectList(Connection con) {
		return null;
	}

	public QnA selectOne(Connection con, int no) {

		return null;
	}

	public int insertQnA(Connection con, QnA qna) {
		return 0;
	}

	public int deleteQnA(Connection con, int no) {
		return 0;
	}

	public int updateQnA(Connection con, QnA qna) {
		return 0;
	}

	public ArrayList<QnA> selectTitleSearch(Connection con, String keyword) {
		return null;
	}

	public int insertComment(Connection con, QComment com) {
		return 0;
	}

	public int deleteComment(Connection con, int cno) {
		return 0;
	}

}
