package com.studyhub.main.qna.model.service;

import java.util.ArrayList;

import com.studyhub.common.vo.QComment;
import com.studyhub.common.vo.QnA;
import com.studyhub.main.qna.model.dao.QnADao;


public class QnAService {
	
	private QnADao qd;
	private QnA qna;
	
	public QnAService(){}
	
	public ArrayList<QnA> selectList(){
		return null;
	}
	
	public QnA selectQNA(int no){
		return null;
	}
	
	public int insertQNA(QnA qna){
		return 0;
	}
	
	public int deleteQNA(int no){
		return 0;
	}
	
	public int updateQNA(QnA qna){
		return 0;
	}
	
	public ArrayList<QnA> selectSearch(String keyword){
		return null;
	}
	

	public int insertComment(QComment com){
		return 0;
	}
	
	public int deleteComment(int cno){
		return 0;
	}
	
	public void updateReadCount(int no){
		
	}
}
