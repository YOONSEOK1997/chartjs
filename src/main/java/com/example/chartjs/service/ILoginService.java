package com.example.chartjs.service;


import java.util.Date;
import java.util.List;

import com.example.chartjs.dto.Member;
import com.example.chartjs.dto.PwHistory;



public interface ILoginService {
	Member login(Member member); 	//로그인

	void saveLoginHistory(String id);

	List<Date> selectLoginHistory(String id);
	
	void changeMemberActiveToOff(String id);

	List<Member> selectSleepingMembers();

	void changePw(Member member);
	
	void deleteOldPwHistory();


}
