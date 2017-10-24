package com.studyhub.group.sharefile.model.service;

import java.sql.Connection;
import java.util.ArrayList;


import com.studyhub.common.vo.ShareFile;
import com.studyhub.group.sharefile.model.dao.ShareFileDao;
import static com.studyhub.common.JDBCTemplate.*;

public class ShareFileService {
	
	private ShareFileDao sfd;
	private ShareFile sharefile;
	
	public ShareFileService(){}

	
	public ArrayList<ShareFile> selectList(int no){
		Connection con = getConnection();
		ArrayList<ShareFile> list = new ShareFileDao().selectList(con, no);
		close(con);
		return list;
	}
	
	public ShareFile selectShareFile(int no){
		Connection con = getConnection();
		ShareFile file = new ShareFileDao().selectOne(con, no);
		close(con);
		return file;
	}
	
	public int insertShareFile(ShareFile sf){
		Connection con = getConnection();
		int result = new ShareFileDao().insertSharedFile(con, sf);
		if(result>0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
		
	}
	public int deleteShareFile(int no){
		Connection con = getConnection();
		int result = new ShareFileDao().deleteSharedFile(con, no);
		if(result>0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}
	public int updateShareFile(ShareFile sf){
		Connection con = getConnection();
		int result = new ShareFileDao().updateSharedFile(con, sf);
		if(result>0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}


	public int updateTextOnly(ShareFile sf) {
		Connection con = getConnection();
		int result = new ShareFileDao().updateTextOnly(con, sf);
		if(result>0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}
	
	public ArrayList<ShareFile> selectSearch(String keyword){
		return null;
	}
	
	public void updateReadCount(int no){
		Connection con = getConnection();
		new ShareFileDao().updateReadCount(con, no);
		
	}
}
