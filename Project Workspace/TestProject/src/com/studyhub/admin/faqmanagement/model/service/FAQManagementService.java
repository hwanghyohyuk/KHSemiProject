package com.studyhub.admin.faqmanagement.model.service;

import java.sql.*;
import java.util.*;

import static com.studyhub.common.JDBCTemplate.close;
import static com.studyhub.common.JDBCTemplate.commit;
import static com.studyhub.common.JDBCTemplate.getConnection;
import static com.studyhub.common.JDBCTemplate.rollback;
import com.studyhub.admin.faqmanagement.model.dao.FAQManagementDao;
import com.studyhub.common.vo.FAQ;

public class FAQManagementService {

	private FAQManagementDao faqmDAO;
	private FAQ faq;
	
	
	public ArrayList<FAQ> faqList(){
		Connection con = getConnection();
		ArrayList<FAQ> list = new FAQManagementDao().faqManagementDaoList(con);
		close(con);
		return list;
	}
	
	public ArrayList<FAQ> faqSearch(String keyword) {
		Connection con = getConnection();
		ArrayList<FAQ> list = new FAQManagementDao().faqManagementSearch(con, keyword);
		close(con);
		return list;
	}

}
