package com.studyhub.group.sharefile.model.service;

import java.util.ArrayList;


import com.studyhub.common.vo.ShareFile;
import com.studyhub.group.sharefile.model.dao.ShareFileDao;

public class ShareFileService {
	
	private ShareFileDao sfd;
	private ShareFile sharefile;
	
	public ShareFileService(){}

	
	public ArrayList<ShareFile> selectList(){
		return null;
	}
	
	public ShareFile selectShareFile(int no){
		return null;
	}
	
	public int insertShareFile(ShareFile sf){
		return 0;
	}
	public int deleteShareFile(int no){
		return 0;
	}
	public int updateShareFile(ShareFile sf){
		return 0;
	}
	public ArrayList<ShareFile> selectSearch(String keyword){
		return null;
	}
	
	public void updateReadCount(int no){
		
	}
}
