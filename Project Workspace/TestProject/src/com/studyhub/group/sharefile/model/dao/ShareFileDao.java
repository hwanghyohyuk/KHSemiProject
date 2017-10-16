package com.studyhub.group.sharefile.model.dao;

import java.sql.Connection;
import java.util.ArrayList;


import com.studyhub.common.vo.ShareFile;



public class ShareFileDao {
	public ShareFileDao(){}
	
	public ArrayList<ShareFile> selectList(Connection con){
		return null;
	}
	
	public ShareFile selectOne(Connection con, int no){
		return null;
	}
	
	public int insertShareFile(Connection con, ShareFile sf){
		return 0;
	}
	
	public int deleteShareFile(Connection con, int no){
		return 0;
		}
	
	public int updateQnA(Connection con, ShareFile sf){
		return 0;
	}
	
	public ArrayList<ShareFile> selectTitleSearch(Connection con, String key){
		return null;
	}
	
}
