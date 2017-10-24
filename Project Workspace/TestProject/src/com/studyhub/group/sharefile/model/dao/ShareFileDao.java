package com.studyhub.group.sharefile.model.dao;

import static com.studyhub.common.JDBCTemplate.close;


import java.sql.*;
import java.util.ArrayList;

import com.studyhub.common.vo.ShareFile;
import com.studyhub.group.sharefile.model.service.ShareFileService;

public class ShareFileDao {

	private ShareFile shareFile;
	
	public ShareFileDao(){}
	
	
	public ArrayList<ShareFile> selectList(Connection con, int groupno){
		ArrayList<ShareFile> list = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select file_no, title, user_name, content, upload_date, originalfilename, renamefilename, downloadcount"
				+ " from tb_share_file" + " join tb_user on (tb_share_file.uploader=tb_user.user_no)"
				+ " where group_no = ? order by file_no desc";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);

			rset = pstmt.executeQuery();
			if (rset != null) {
				list = new ArrayList<ShareFile>();
				while (rset.next()) {
					ShareFile sf = new ShareFile();
					sf.setFileNo(rset.getInt("file_no"));
					sf.setTitle(rset.getString("title"));
					sf.setUserName(rset.getString("user_name"));
					sf.setContent(rset.getString("content"));
					sf.setUploadDate(rset.getDate("upload_date"));
					sf.setFileName(rset.getString("originalfilename"));
					sf.setRenameFileName(rset.getString("renamefilename"));
					sf.setDownloadCount(rset.getInt("downloadcount"));
					list.add(sf);

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
	
	
	public ShareFile selectOne(Connection con, int no){
		ShareFile sf = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select file_no, title, user_name, content, upload_date, originalfilename, renamefilename, downloadcount"
				+ " from tb_share_file" + " join tb_user on (tb_share_file.uploader=tb_user.user_no) where file_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				sf = new ShareFile();
				
				sf.setFileNo(rset.getInt("file_no"));
				sf.setTitle(rset.getString("title"));
				sf.setContent(rset.getString("content"));
				sf.setUserName(rset.getString("user_name"));
				sf.setFileName(rset.getString("originalfilename"));
				sf.setRenameFileName(rset.getString("renamefilename"));
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
					"?, ?, default, ?, ?, ?, ?, ?, default)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, sf.getTitle());
			pstmt.setString(2, sf.getContent());
			pstmt.setString(3, sf.getFileName());
			pstmt.setString(4, sf.getRenameFileName());
			pstmt.setInt(5, sf.getGroupNo());
			pstmt.setInt(6, sf.getUploader());
			pstmt.setInt(7, sf.getAccessNo());
			
			result = pstmt.executeUpdate(); 
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		return result;
	}
	
	
	public int deleteSharedFile(Connection con, int no){
		int result =0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_share_file where file_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		return result;
		}
	
	public int updateSharedFile(Connection con, ShareFile sf){
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_share_file set title = ?, content = ?, originalfilename = ?, renamefilename = ? "
				+"where file_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, sf.getTitle());
			pstmt.setString(2, sf.getContent());
			pstmt.setString(3, sf.getFileName());
			pstmt.setString(4, sf.getRenameFileName());
			pstmt.setInt(5, sf.getFileNo());
			
			result = pstmt.executeUpdate(); 
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateTextOnly(Connection con, ShareFile sf){
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_share_file set title = ?, content = ?"
				+"where file_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, sf.getTitle());
			pstmt.setString(2, sf.getContent());
			pstmt.setInt(3, sf.getFileNo());
			System.out.println("여기로 오닝??? ");
			result = pstmt.executeUpdate(); 
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<ShareFile> selectTitleSearch(Connection con, String key){
		return null;
	}

	//수정해야됨 ㅋㅋㅋ
	public void updateReadCount(Connection con, int no) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_qna set readcount = readcount+1 where qna_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
	}
	
}
