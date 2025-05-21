package com.example.chartjs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.chartjs.dto.SampleForm;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class SampleController {
	@GetMapping("/addSample")
	public String addSample() {
		return "addSample";
	}
	@PostMapping("/addSample")
	public String addSample(@Valid  SampleForm sampleForm , Errors errors ,Model model) {
		log.info(sampleForm.toString());
		  // 매개값으로 넘겨지는 커맨드객체의 경우 별도로 모델에 추가하지 않아도 View에서 사용가능하다.
		   // 커맨드객체의 생명주기는 request_scope와 동일하다
				System.out.println(sampleForm.getName());
				System.out.println("hassErrors :" + errors.hasErrors()); // 유효성 검사후 에러 발견시 true
		        System.out.println(errors); // 에러의 갯수 확인
				if(errors.hasErrors()) {
					for(FieldError e : errors.getFieldErrors()) {
						// 에러가 발생한 form 필드 name
						System.out.println(e.getField());
						// 커맨드 객체에서 에러 발생시 맵핑된 에러메세지 
						System.out.println(e.getDefaultMessage());
						// "이름+Msg"에 메세지를 담아 모델에 추가
						model.addAttribute(e.getField()+"Msg", e.getDefaultMessage());
					}
					return "addSample"; // 입력 에러 발생시 입력폼으로 포워딩(+ 커맨드객체내용 + 추가된 모델 에러 메세지)
				}
				
				return "redirect:/"; // 정상 입력시 이동 리다이렉트
			}
		
}
