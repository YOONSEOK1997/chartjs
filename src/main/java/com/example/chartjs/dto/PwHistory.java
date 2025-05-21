package com.example.chartjs.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PwHistory {
    private int no;
    private String id;
    private String pw;
    private Date changeDate;
}
