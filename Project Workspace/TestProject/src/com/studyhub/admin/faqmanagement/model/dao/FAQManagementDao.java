package com.studyhub.admin.faqmanagement.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static com.studyhub.common.JDBCTemplate.*;
import com.studyhub.common.vo.FAQ;


public class FAQManagementDao {

	private FAQ faq;


	public int insertFAQ(Connection con, String title, String content, int categoryno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_faq values((select max(faq_no)+1 from tb_faq), ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, categoryno);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
		
	}

	public ArrayList<FAQ> selectList(Connection con, int categoryno) {
		ArrayList<FAQ> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select faq_no, title, content, faq_category_no, faq_category_name from tb_faq join tb_faq_category using (faq_category_no) where faq_category_no = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, categoryno);

			rset = pstmt.executeQuery();
			if (rset != null) {
				list = new ArrayList<FAQ>();
				while (rset.next()) {
					FAQ faq = new FAQ();
					faq.setFaqNo(rset.getInt("faq_no"));
					faq.setTitle(rset.getString("title"));
					faq.setContent(rset.getString("content"));
					faq.setFaqCategoryNo(rset.getInt("faq_category_no"));
					faq.setFaqCategoryName(rset.getString("faq_category_name"));
					list.add(faq);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int deleteFAQ(Connection con, int no) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_faq where faq_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateFAQ(Connection con, FAQ faq) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "update tb_faq set title = ?, content = ?, faq_category_no = ? where faq_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, faq.getTitle());
			pstmt.setString(2, faq.getContent());
			pstmt.setInt(3, faq.getFaqCategoryNo());
			pstmt.setInt(4, faq.getFaqNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public FAQ selectOneFAQ(Connection con, int no) {
		FAQ faq = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select title, content, faq_no, faq_category_no from tb_faq where faq_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				faq = new FAQ();
				faq.setTitle(rset.getString("title"));
				faq.setContent(rset.getString("content"));
				faq.setFaqNo(rset.getInt("faq_no"));
				faq.setFaqCategoryNo(rset.getInt("faq_category_no"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return faq;
	}
	
	
}
