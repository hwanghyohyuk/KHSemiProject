package com.studyhub.group.schedule.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.studyhub.common.vo.Schedule;

public class ScheduleDao {
	
	private Schedule schedule;

	public ArrayList<Schedule> selectList(Connection con) {
		ArrayList<Schedule> slist = null;
		return slist;
		
	}

	public Boolean insertSchedule(Connection con, Schedule schedule) {
		Boolean result = false;		
		
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

