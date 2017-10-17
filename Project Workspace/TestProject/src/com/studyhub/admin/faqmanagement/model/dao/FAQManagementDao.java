package com.studyhub.admin.faqmanagement.model.dao;

import java.sql.Connection;
import java.util.ArrayList;
import static com.studyhub.common.JDBCTemplate.*;
import com.studyhub.common.vo.FAQ;

public class FAQManagementDao {

	private FAQ faq;

	public ArrayList<FAQ> faqList(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<FAQ> faqSearch(Connection con, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public FAQ faqView(Connection con, int faqno) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean faqDelete(Connection con, int faqno) {
		boolean result = false;
		
		
		
		
		if(!result){
			commit(con);
		}else{
			rollback(con);
		}
		
		return result;
	}
	
	
}
