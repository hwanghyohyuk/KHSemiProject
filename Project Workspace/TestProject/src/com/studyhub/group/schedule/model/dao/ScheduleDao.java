package com.studyhub.group.schedule.model.dao;

import static com.studyhub.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.studyhub.common.vo.Schedule;

public class ScheduleDao {
	
	private Schedule schedule;

	public ArrayList<Schedule> selectList(Connection con, int groupno) {
		ArrayList<Schedule> list = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select schedule_no, group_no, meeting_date, ampm, hour, minute, onoff, meeting_name" 
					 + " from tb_schedule"
					 + " where group_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, groupno);
			
			rset = pstmt.executeQuery();
			if(rset != null){
				list = new ArrayList<Schedule>();
				while(rset.next()){
					Schedule sc = new Schedule();
					sc.setScheduleNo(rset.getInt("schedule_no"));
					sc.setGroupNo(rset.getInt("group_no"));
					sc.setMeetingDate(rset.getString("meeting_date"));
					sc.setAmpm(rset.getString("ampm"));
					sc.setHour(rset.getInt("hour"));
					sc.setMinute(rset.getInt("minute"));
					sc.setOnoff(rset.getString("onoff"));
					sc.setMeetingName(rset.getString("meeting_name"));
					
					list.add(sc);
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

	public int insertSchedule(Connection con, Schedule sc) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_schedule values ("
					+ " (select max(schedule_no)+1 from tb_schedule),"
					+ " ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sc.getGroupNo());
			pstmt.setString(2, sc.getMeetingDate());
			pstmt.setString(3, sc.getAmpm());
			pstmt.setInt(4, sc.getHour());
			pstmt.setInt(5, sc.getMinute());
			pstmt.setString(6, sc.getOnoff());
			pstmt.setString(7, sc.getMeetingName());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Schedule selectSchedule(Connection con, int scheduleNo) {
		Schedule schedule = null;
		
		
		return schedule;
	}

	public Boolean delectSchedule(Connection con, Schedule schedule) {
		Boolean result = false;
		return result;
	}

	public Boolean updateSchedule(Connection con, Schedule scheduleNo) {
		Boolean result = false;
		return result;
	}

	
	
}

