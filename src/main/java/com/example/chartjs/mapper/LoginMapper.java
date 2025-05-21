package com.example.chartjs.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.example.chartjs.dto.Member;
import com.example.chartjs.dto.PwHistory;

@Mapper
public interface LoginMapper {
	Member login(Member Member);

	void insertLoginHistory(String id);

	List<Date> selectLoginHistory(String id);

	void changeMemberActiveToOff(String id);

	List<Member> selectSleepingMembers();

	void changePw(Member member);

	void insertPwHistory(PwHistory pwHistory);

	void deleteOldPwHistory();
	
	List<String> selectPastPasswords(Member member);

}
