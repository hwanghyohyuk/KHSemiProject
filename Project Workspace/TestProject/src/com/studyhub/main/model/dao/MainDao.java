package com.studyhub.main.model.dao;

import static com.studyhub.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.studyhub.common.vo.Board;
import com.studyhub.common.vo.Group;
import com.studyhub.common.vo.UNG;

public class MainDao {
	
	private UNG ung;
	private Group group;
	private Board board;

	public ArrayList<UNG> selectJoinGroup(Connection con, int userno) {
		ArrayList<UNG> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select group_no, group_name, usercount "
						  + "from tb_ung "
						  + "join (select group_no, count(*) as usercount "
						  		+ "from tb_ung "
						  		+ "group by group_no) "
						  + "using(group_no) "
						  + "join tb_group using(group_no) "
						  + "where user_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userno);
			
			rset = pstmt.executeQuery();
			if(rset != null) {
				list = new ArrayList<UNG>();
				while(rset.next()) {
					UNG ung = new UNG();
					ung.setGroupNo(rset.getInt("group_no"));
					ung.setGroupName(rset.getString("group_name"));
					ung.setCount(rset.getInt("usercount"));
					
					list.add(ung);
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

}
