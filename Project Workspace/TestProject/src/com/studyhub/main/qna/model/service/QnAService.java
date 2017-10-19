package com.studyhub.main.qna.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.studyhub.common.vo.GQNA;
import com.studyhub.common.vo.QComment;
import com.studyhub.common.vo.QnA;
import com.studyhub.group.qna.model.dao.GroupQnADao;
import com.studyhub.main.qna.model.dao.QnADao;

import static com.studyhub.common.JDBCTemplate.*;



public class QnAService {
	
	private QnADao qd;
	private QnA qna;
	
	public QnAService(){}
	
	public ArrayList<QnA> selectList(){
		Connection con = getConnection();
		ArrayList<QnA> list = new QnADao().selectList(con);
		close(con);
		
		return list;
	}
	
	public QnA selectQNA(int no){
		Connection con = getConnection();
		qna = new QnADao().selectOne(con, no);
		close(con);
		
		return qna;
	}
	
	public int insertQNA(QnA qna){
		Connection con = getConnection();
		int result = new QnADao().insertQnA(con, qna);
		if(result>0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}
	
	public int deleteQNA(int no){
		Connection con = getConnection();
		int result = new QnADao().deleteQnA(con, no);
		if(result>0)
			commit(con);
		else
			rollback(con);
		close(con);
		
		return result;
	}
	
	public int updateQNA(QnA qna){
		Connection con = getConnection();
		int result = new QnADao().updateQnA(con, qna);
		if(result>0)
			commit(con);
		else
			rollback(con);
		close(con);
		
		return result;
	}
	
	public ArrayList<QnA> selectSearch(String keyword){
		Connection con = getConnection();
		ArrayList<QnA> list = new QnADao().selectTitleSearch(con, keyword);
		close(con);
		
		return list;
	}
	

	public int insertComment(QComment com){
		return 0;
	}
	
	public int deleteComment(int cno){
		return 0;
	}
	
	public void updateReadCount(int no){
		Connection con = getConnection();
		int result = new QnADao().updateReadCount(con, no);
		if(result >0)
			commit(con);
		else
			rollback(con);
		close(con);
	}
}
