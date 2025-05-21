package com.example.chartjs.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.chartjs.dto.Member;
import com.example.chartjs.dto.PwHistory;
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
	@Override
	public void changeMemberActiveToOff(String id) {
		 loginMapper.changeMemberActiveToOff(id);
		
	}
	@Override
	public List<Member> selectSleepingMembers() {
		// TODO Auto-generated method stub
		return loginMapper.selectSleepingMembers();
	}
	@Override
	public void changePw(Member member) {
	    // 1. 비밀번호 중복 검사
	    List<String> pastPwList = loginMapper.selectPastPasswords(member);
	    for (String oldPw : pastPwList) {
	        if (member.getPw().equals(oldPw)) {
	            throw new IllegalArgumentException("이전에 사용한 비밀번호는 사용할 수 없습니다.");
	        }
	    }

	    // 2. 비밀번호 변경
	    loginMapper.changePw(member);

	    // 3. 비밀번호 이력 저장
	    PwHistory history = new PwHistory();
	    history.setId(member.getId());
	    history.setPw(member.getPw());
	    loginMapper.insertPwHistory(history);
	}

	@Override
	public void deleteOldPwHistory() {
		loginMapper.deleteOldPwHistory();;
		
	}
	

	
}


