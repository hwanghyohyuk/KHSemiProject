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
	public ArrayList<Schedule> selectList(){
		Connection con = getConnection();
		ArrayList<Schedule> list = new ScheduleDao().selectList(con);
		return list;
	}
	
	// 일정 등록
	public Boolean insertSchedule(Schedule schedule){
		Connection con = getConnection();
		Boolean result = new ScheduleDao().insertSchedule(con, schedule);
		return result;
		
	}
	// 일정 상세보기
	public Schedule selectSchedule(int scheduleNo){
		Connection con = getConnection();
		Schedule schedule = new ScheduleDao().selectSchedule(con,scheduleNo);
		return schedule;
		
	}
	
	// 일정 삭제
	public Boolean delectSchedule(Schedule schedule){
		Connection con = getConnection();
		Boolean result = new ScheduleDao().delectSchedule(con, schedule);
		return result;
		
	}
	
	// 일정 수정
	public Boolean updateSchedule(Schedule scheduleNo){
		Connection con = getConnection();
		Boolean result = new ScheduleDao().updateSchedule(con,scheduleNo);
		return result;
		
	}	

	
}
