package com.studyhub.group.sharefile.model.dao;

import static com.studyhub.common.JDBCTemplate.close;


import java.sql.*;
import java.util.ArrayList;

import com.studyhub.common.vo.ShareFile;
import com.studyhub.group.sharefile.model.service.ShareFileService;

public class ShareFileDao {

	private ShareFile shareFile;
	
	public ShareFileDao(){}
	
	
	public ArrayList<ShareFile> selectList(Connection con, int groupno, int currentPage, int limit){
		ArrayList<ShareFile> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select *"
				+ " from (select rownum rnum, file_no, group_no, title, user_name, content, "
				+ "upload_date, originalfilename, renamefilename, downloadcount, file_category_name "
				+ "from (select file_no, fc.group_no, title, user_name, content, upload_date, originalfilename, "
				+ "renamefilename, downloadcount, file_category_name from tb_share_file sf "
				+ "join tb_user us on (sf.uploader=us.user_no) join tb_file_category fc "
				+ "on(sf.file_category_no=fc.file_category_no) where sf.group_no = ? "
				+ "order by upload_date desc, file_no asc)) where rnum >= ? and rnum <= ?";
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit -1;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

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
					sf.setFileCategoryName(rset.getString("file_category_name"));
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
					"?, ?, default, ?, ?, ?, ?, ?, 0, ?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, sf.getTitle());
			pstmt.setString(2, sf.getContent());
			pstmt.setString(3, sf.getFileName());
			pstmt.setString(4, sf.getRenameFileName());
			pstmt.setInt(5, sf.getGroupNo());
			pstmt.setInt(6, sf.getUploader());
			pstmt.setInt(7, sf.getAccessNo());
			pstmt.setInt(8, sf.getFileCategoryNo());
			
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
			result = pstmt.executeUpdate(); 
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<ShareFile> selectSearch(Connection con, String keyword){
		ArrayList<ShareFile> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select file_no, title, user_name, content, upload_date, originalfilename, renamefilename, downloadcount"
				+ " from tb_share_file" + " join tb_user on (tb_share_file.uploader=tb_user.user_no)"
				+ " where upper(originalfilename) like ? or upper(title) like ?"
				+ " order by file_no desc";

		try {
			pstmt = con.prepareStatement(query);
			keyword = keyword.toUpperCase();
			
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");

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

	


	public int addDownloadCount(Connection con, String rfileName) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_share_file set downloadcount = downloadcount + 1 where renamefilename = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rfileName);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		return result;
	
	}


	public int getListCount(Connection con) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from tb_share_file";
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next())
				result = rset.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(stmt);
		}
		return result;
	}


	public ArrayList<ShareFile> selectCategory(Connection con, int no) {
		
		ArrayList<ShareFile> clist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select distinct tb_file_category.file_category_no, tb_file_category.file_category_name "
				+ "from tb_file_category left join tb_share_file "
				+ "on(tb_share_file.file_category_no = tb_file_category.file_category_no)"
				+ " where tb_file_category.group_no = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			if (rset != null) {
				clist = new ArrayList<ShareFile>();
				while (rset.next()) {
					ShareFile sf = new ShareFile();
					sf.setFileCategoryNo(rset.getInt("file_category_no"));
					sf.setFileCategoryName(rset.getString("file_category_name"));
					clist.add(sf);
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			close(rset);
			close(pstmt);
		}

		return clist;
	}


	public int addCategory(Connection con, int groupno, String cname) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_file_category values ((select max(file_category_no)+1 from tb_file_category), ?, ?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cname);
			pstmt.setInt(2, groupno);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		return result;
	}


	/*public ArrayList<String> selectCategoryName(Connection con, int no) {
		ArrayList<String> clist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select distinct file_category_name from tb_file_category where group_no = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			if (rset != null) {
				clist = new ArrayList<String>();
				while (rset.next()) {
					String cname = rset.getString("file_category_name");
					clist.add(cname);
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			close(rset);
			close(pstmt);
		}

		return clist;
	}*/
	
}
