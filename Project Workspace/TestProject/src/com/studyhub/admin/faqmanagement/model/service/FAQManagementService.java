package com.studyhub.admin.faqmanagement.model.service;

import java.sql.*;
import java.util.*;

import static com.studyhub.common.JDBCTemplate.*;
import com.studyhub.admin.faqmanagement.model.dao.FAQManagementDao;
import com.studyhub.common.vo.FAQ;
import com.studyhub.common.vo.QnA;
import com.studyhub.main.qna.model.dao.QnADao;

public class FAQManagementService {

	private FAQManagementDao faqmd;
	private FAQ faq;
	

	public int insertFAQ(String title, String content, int categoryno) {
		Connection con = getConnection();
		System.out.println("service ");
		int result = new FAQManagementDao().insertFAQ(con, title, content, categoryno);
		close(con);
		return result;
	}

	public ArrayList<FAQ> selectList(int categoryno) {
		Connection con = getConnection();
		faqmd =  new FAQManagementDao();
		ArrayList<FAQ> list = faqmd.selectList(con, categoryno);
		close(con);
		return list;
	}
	
	public int deleteFAQ(int no){
		Connection con = getConnection();
		int result = new FAQManagementDao().deleteFAQ(con, no);
		if(result>0)
			commit(con);
		else
			rollback(con);
		close(con);
		
		return result;
	}
	
	public int updateFAQ(FAQ faq){
		Connection con = getConnection();
		int result = new FAQManagementDao().updateFAQ(con, faq);
		if(result>0)
			commit(con);
		else
			rollback(con);
		close(con);
		
		return result;
	}

	public FAQ selectOneFAQ(int no) {
		Connection con = getConnection();
		FAQ f = new FAQManagementDao().selectOneFAQ(con, no);
		close(con);
		return f;
	}
	
}
