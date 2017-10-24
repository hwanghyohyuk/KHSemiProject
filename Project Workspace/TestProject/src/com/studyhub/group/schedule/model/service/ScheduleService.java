package com.studyhub.group.schedule.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.studyhub.common.vo.Schedule;
import com.studyhub.group.schedule.model.dao.ScheduleDao;
import static com.studyhub.common.JDBCTemplate.*;

public class ScheduleService {
	private ScheduleDao scheduledao;
	private Schedule schedule;
	
	// 일정 리스트 목록
	public ArrayList<Schedule> selectList(int groupno){
		Connection con = getConnection();
		ArrayList<Schedule> list = new ScheduleDao().selectList(con, groupno);
		close(con);
		return list;
	}
	
	// 일정 등록
	public int insertSchedule(Schedule sc){
		Connection con = getConnection();
		int result = new ScheduleDao().insertSchedule(con, sc);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
		
	}

	public ArrayList<Schedule> selectOne(int scheduleno) {
		Connection con = getConnection();
		ArrayList<Schedule> list = new ScheduleDao().selectOne(con, scheduleno);
		close(con);
		return list;
	}

	public int deleteSchedule(int scheduleno) {
		Connection con = getConnection();
		int result = new ScheduleDao().deleteSchedule(con, scheduleno);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int updateSchedule(Schedule sc) {
		Connection con = getConnection();
		int result = new ScheduleDao().updateSchedule(con, sc);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}
}
