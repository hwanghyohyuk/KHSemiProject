package com.studyhub.group.sharefile.model.dao;

import java.sql.Connection;
import java.util.ArrayList;


import com.studyhub.common.vo.SharedFile;

public class ShareFileDao {
	public ShareFileDao(){}
	
	public ArrayList<SharedFile> selectList(Connection con){
		return null;
	}
	
	public SharedFile selectOne(Connection con, int no){
		return null;
	}
	
	public int insertSharedFile(Connection con, SharedFile sf){
		return 0;
	}
	
	public int deleteSharedFile(Connection con, int no){
		return 0;
		}
	
	public int updateQnA(Connection con, SharedFile sf){
		return 0;
	}
	
	public ArrayList<SharedFile> selectTitleSearch(Connection con, String key){
		return null;
	}
	
}
