package com.studyhub.admin.faqmanagement.model.service;

import java.sql.*;
import java.util.*;

import static com.studyhub.common.JDBCTemplate.*;
import com.studyhub.admin.faqmanagement.model.dao.FAQManagementDao;
import com.studyhub.common.vo.FAQ;

public class FAQManagementService {

	private FAQManagementDao faqmd;
	private FAQ faq;
	
	
	public ArrayList<FAQ> faqList(){
		Connection con = getConnection();
		faqmd =  new FAQManagementDao();
		ArrayList<FAQ> list = faqmd.faqList(con);
		close(con);
		return list;
	}
	
	public ArrayList<FAQ> faqSearch(String keyword) {
		Connection con = getConnection();
		faqmd =  new FAQManagementDao();
		ArrayList<FAQ> list = faqmd.faqSearch(con, keyword);
		close(con);
		return list;
	}

	public FAQ faqView(int faqno){
		Connection con = getConnection();
		faqmd =  new FAQManagementDao();
		FAQ faq = faqmd.faqView(con, faqno);
		close(con);
		return faq;
	}
	
	public boolean faqDelete(int faqno){
		Connection con = getConnection();
		faqmd =  new FAQManagementDao();
		boolean result = faqmd.faqDelete(con,faqno);
		close(con);
		return result;		
	}
	
}
