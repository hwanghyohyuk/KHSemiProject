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
	public int insertSchedule(int groupno){
		Connection con = getConnection();
		int result = new ScheduleDao().insertSchedule(con, groupno);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
		
	}
}
