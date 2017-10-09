package com.studyhub.main.qna.model.service;

import java.util.ArrayList;

import com.studyhub.main.qna.model.vo.QnA;
import com.studyhub.main.qna.model.vo.QnAComment;

public class QnAService {
	public QnAService(){}
	
	public ArrayList<QnA> selectList(){
		return null;
	}
	
	public QnA selectQnA(int no){
		return null;
	}
	
	public int insertQnA(QnA qna){
		return 0;
	}
	
	public int deleteQnA(int no){
		return 0;
	}
	
	public int updateQnA(QnA qna){
		return 0;
	}
	
	public ArrayList<QnA> selectSearch(String keyword){
		return null;
	}
	
	public int insertComment(QnAComment com){
		return 0;
	}
	
	public int deleteComment(int cno){
		return 0;
	}
	
	public void updateReadCount(int no){
		
	}
}
