package com.studyhub.group.schedule.model.dao;

import static com.studyhub.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.studyhub.common.vo.Schedule;

public class ScheduleDao {
	
	private Schedule schedule;

	public ArrayList<Schedule> selectList(Connection con, int groupno) {
		ArrayList<Schedule> slist = null;
		
		
		
		return slist;
		
	}

	public int insertSchedule(Connection con, int groupno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "";
		
		try {
			
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

