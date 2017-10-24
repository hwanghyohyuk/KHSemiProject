package com.studyhub.group.sharefile.model.dao;

import static com.studyhub.common.JDBCTemplate.close;


import java.sql.*;
import java.util.ArrayList;

import com.studyhub.common.vo.GNotice;
import com.studyhub.common.vo.ShareFile;
import com.studyhub.group.sharefile.model.service.ShareFileService;

public class ShareFileDao {

	private ShareFile shareFile;
	
	public ShareFileDao(){}
	
	
	public ArrayList<ShareFile> selectList(Connection con){
		ArrayList<ShareFile> list = null;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_share_file order by file_no desc";
		try{
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset != null){
				list = new ArrayList<ShareFile>();
				
				while(rset.next()){
					ShareFile sf = new ShareFile();
					sf.setFileNo(rset.getInt("file_no"));
					sf.setTitle(rset.getString("title"));
					sf.setContent(rset.getString("content"));
					sf.setFileName(rset.getString("originalfilename"));
					sf.setDownloadCount(rset.getInt("downloadcount"));
					sf.setUploadDate(rset.getDate("upload_date"));
					
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}
	
	public ShareFile selectOne(Connection con, int no){
		ShareFile sf = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_share_file where file_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				sf = new ShareFile();
				
				sf.setFileNo(rset.getInt("file_no"));
				sf.setTitle(rset.getString("title"));
				sf.setContent(rset.getString("content"));
				sf.setFileName(rset.getString("originalfilename"));
				sf.setDownloadCount(rset.getInt("downloadcount"));
				sf.setUploadDate(rset.getDate("upload_date"));
				
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			close(rset);
			close(pstmt);
		}
		return sf;
	}
	
	public int insertSharedFile(Connection con, ShareFile sf){
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_share_file values "+
					"((select max(file_no)+1 from tb_share_file), "+
					"?, ?, sysdate, ?, ?, ?, ?, null, default)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, sf.getTitle());
			pstmt.setString(2, sf.getContent());
			pstmt.setString(3, sf.getFileName());
			pstmt.setString(4, sf.getRenameFileName());
			pstmt.setInt(5, sf.getUploader());
			pstmt.setInt(6, sf.getAccessNo());
			pstmt.setInt(7, sf.getGroupNo());
			
			result = pstmt.executeUpdate(); 
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		System.out.println(result+"result");
		return result;
	}
	
	
	public int deleteSharedFile(Connection con, int no){
		return 0;
		}
	
	public int updateSharedFile(Connection con, ShareFile sf){
		return 0;
	}
	
	public ArrayList<ShareFile> selectTitleSearch(Connection con, String key){
		return null;
	}
	
}
