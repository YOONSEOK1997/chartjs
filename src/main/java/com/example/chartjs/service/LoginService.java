package com.example.chartjs.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.chartjs.dto.Member;
import com.example.chartjs.mapper.LoginMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class LoginService implements ILoginService {


	@Autowired
	private LoginMapper loginMapper;

	//로그인
	@Override
	public Member login(Member member) {
		return loginMapper.login(member);
	}
	 @Override
	    public void saveLoginHistory(String id) {
	        loginMapper.insertLoginHistory(id);
	    }
	 @Override
	 public List<Date> selectLoginHistory(String id) {
	     return loginMapper.selectLoginHistory(id);
	 }
	
}


