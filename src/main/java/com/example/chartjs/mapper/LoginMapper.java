package com.example.chartjs.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.chartjs.dto.Member;

@Mapper
public interface LoginMapper {
	Member login(Member Member);

	void insertLoginHistory(String id);

	List<Date> selectLoginHistory(String id);

	void changeMemberActiveToOff(String id);

	List<Member> selectSleepingMembers();


}
