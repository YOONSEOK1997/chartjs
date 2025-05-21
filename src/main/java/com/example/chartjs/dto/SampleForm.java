package com.example.chartjs.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SampleForm {
	@NotBlank(message = "이름을 입력하세요")
	@Size(min = 4, max= 10 , message="아이디는 4자이상 10자 이하여야 합니다")
	private String name;
	
	@Min(value =0 , message = "나이는 0~200")
	@Max(value = 200, message ="나이는 0~200")
	private int age;
}
