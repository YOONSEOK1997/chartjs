package com.example.chartjs.service;


import java.util.Date;
import java.util.List;

import com.example.chartjs.dto.Member;



public interface ILoginService {
	Member login(Member member); 	//로그인

	void saveLoginHistory(String id);



	List<Date> selectLoginHistory(String id);
	
}
