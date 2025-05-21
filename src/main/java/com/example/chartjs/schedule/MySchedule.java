package com.example.chartjs.schedule;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.chartjs.dto.Member;
import com.example.chartjs.mapper.LoginMapper;
import com.example.chartjs.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MySchedule {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private LoginService loginService;
   
    @Scheduled(cron = "0 59 23 25 * *")
    public void findSleepingMembers() {
        List<Member> sleepingMembers = loginService.selectSleepingMembers();

        for (Member member : sleepingMembers) {
            loginService.changeMemberActiveToOff(member.getId());
           
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom("admin@localhost.com");
            msg.setTo(member.getEmail());
            msg.setSubject("당신의 계정은 휴면입니다 휴먼");
            msg.setText("수고하세요.");

            javaMailSender.send(msg);
        }
    }
    @Scheduled(cron "0 0 0 0 * 1)
   //@Scheduled(cron ="0 * * * * * ")
   public void deleteOldPwHistory() {
	   loginService.deleteOldPwHistory();
   }
}
	//휴면계정으로 만드는 서비스 메서드
	//메일을 보내는 서비스 메서드
	//1개월 지난 로그인 이력을 삭제하는 서비스 메서드
	
	//매월 25일 23시 59분 59초 스케줄러 호출
	//마지막 접속이 1년전 휴면계정으로 만드는 서비스 메서드 ON->OFF
	//메일을 보내는 서비스 메서드
	
	//매월1일 0시0분0초 스케줄러 호출
	//1개월 지난 로그인 이력을 삭제하는 서비스 메서드
	
	//로그인 컨트롤러 호출
	//로그인시 이력을 입력하는 메서드

