package com.studyhub.main.model.dao;

import static com.studyhub.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.studyhub.common.vo.Board;
import com.studyhub.common.vo.Group;
import com.studyhub.common.vo.Message;
import com.studyhub.common.vo.UNG;

public class MainDao {
	
	private UNG ung;
	private Group group;
	private Board board;

	public ArrayList<UNG> selectJoinGroup(Connection con, int userno) {
		ArrayList<UNG> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select group_no, group_name, usercount, g_img_rename "
						  + "from tb_ung "
						  + "join (select group_no, count(*) as usercount "
						  		+ "from tb_ung "
						  		+ "group by group_no) "
						  + "using(group_no) "
						  + "join tb_group using(group_no) "
						  + "where user_no = ? "
						  + "and ung_state = 1 "
						  + "and group_state in (0, 1)";
		
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
					ung.setRenameimg(rset.getString("g_img_rename"));
					
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

	public int InsertGroup(Connection con, Group g) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_group values ("
					+  "(select max(group_no) + 1 from tb_group), "
					+  "?, ?, ?, ?, ?, ?, ?, default, sysdate)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, g.getGroupName());
			pstmt.setInt(2, g.getAttributeNo());
			pstmt.setString(3, g.getLocation());
			pstmt.setInt(4,g.getCategoryNo());
			pstmt.setString(5, g.getDescription());
			pstmt.setString(6, g.getG_img_original());
			pstmt.setString(7, g.getG_img_rename());
			
			result = pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertUnG(Connection con, int userNo, int groupNo, int authorityNo, int ungState) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_ung values ("
					+  "(select max(ung_no) + 1 from tb_ung), "
					+  "?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, groupNo);
			pstmt.setInt(3, authorityNo);
			pstmt.setInt(4, ungState);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int selectGroupNo(Connection con, String groupname) {
		int groupNo = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select group_no from tb_group where group_name = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, groupname);
			
			rset = pstmt.executeQuery();
			if(rset.next()){
				groupNo = rset.getInt("group_no");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return groupNo ;
	}
	
	public int countGroup(Connection con, String userEmail) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "select count(*) "
					+  "from tb_ung "
					+  "join tb_group using(group_no) "
					+  "where user_no = (select user_no "
					+ 					"from tb_user "
					+					"where email = ?) "
					+  "and ung_state = 1 "
					+  "and group_state in (0, 1) "
					+  "group by user_no";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userEmail);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int MessageCount(Connection con, int userno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) as messagecount " +
						"from tb_message " +
						"where message_state in (0,1) " +
						"and receiver = ? " +
						"group by receiver";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userno);
			
			rset = pstmt.executeQuery();
			if(rset != null){
				while(rset.next()){
					result = rset.getInt("messagecount");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Message> MessageSelect(Connection con, int userno) {
		ArrayList<Message> list = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select message_no, message, group_no, group_name, sender, receiver, message_state, user_name "
				+ "from tb_message "
				+ "join tb_group using(group_no) "
				+ "join tb_user on (sender=user_no) "
				+ "where receiver = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userno);
			
			rset = pstmt.executeQuery();
			if(rset != null){
				list = new ArrayList<Message>();
				while(rset.next()){
					Message m = new Message();
					m.setMessageNo(rset.getInt("message_no"));
					m.setMessage(rset.getString("message"));
					m.setGroupNo(rset.getInt("group_no"));
					m.setGroupName(rset.getString("group_name"));
					m.setSenderNo(rset.getInt("sender"));
					m.setReceiverNo(rset.getInt("receiver"));
					m.setMessageState(rset.getInt("message_state"));
					m.setUserName(rset.getString("user_name"));
					
					list.add(m);
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

	public int InviteAgree(Connection con, int groupno, int receiver) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_ung values ("
				+ "(select max(ung_no) + 1 from tb_message) "
				+ ", ?, ?, 1, 1)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, receiver);
			pstmt.setInt(2, groupno);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int changeMessage1(Connection con, int messageno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "update tb_message set message_state = 2 where message_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, messageno);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int InsertMessage(Connection con, int groupno, int sender, int receiver) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_message values("
				+ "(select max(message_no) + 1 from tb_message) "
				+ ", ?, ?, ?, 1, '가입초대를 승인하였습니다.') ";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			pstmt.setInt(2, receiver);
			pstmt.setInt(3, sender);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int InsertMessage2(Connection con, int groupno, int sender, int receiver) {
int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_message values("
				+ "(select max(message_no) + 1 from tb_message) "
				+ ", ?, ?, ?, 1, '가입초대를 거절하였습니다.') ";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			pstmt.setInt(2, receiver);
			pstmt.setInt(3, sender);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int InsertMessage3(Connection con, int groupno, int sender, int receiver) {
		int result = 0;
				
				PreparedStatement pstmt = null;
				
				String query = "insert into tb_message values("
						+ "(select max(message_no) + 1 from tb_message) "
						+ ", ?, ?, ?, 1, '가입신청을 하였습니다.') ";
				
				try {
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1, groupno);
					pstmt.setInt(2, sender);
					pstmt.setInt(3, receiver);
					
					result = pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
				}
				return result;
			}
}
