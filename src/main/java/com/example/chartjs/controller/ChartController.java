package com.example.chartjs.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.chartjs.dto.Member;
import com.example.chartjs.service.ILoginService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class ChartController {
	@Autowired ILoginService loginService;
	
	
	@GetMapping({"/","/login"})
	public String login(){
		return "login";
	}
	@PostMapping("/login")
	public String login(
	        HttpSession session,
	        @ModelAttribute Member member,
	        HttpServletResponse response,
	        Model model
	) {
	    Member loginMember = loginService.login(member);

	    if (loginMember == null) {
	        model.addAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
	        return "login";
	    }

	    session.setAttribute("loginMember", loginMember);
	    loginService.saveLoginHistory(loginMember.getId());

	    List<Date> loginHistory = loginService.selectLoginHistory(loginMember.getId());
	    model.addAttribute("loginHistory", loginHistory);

	    return "login"; 
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate(); // 세션 초기화
	    return "redirect:/login"; // 로그인 페이지로 이동
	}
}
