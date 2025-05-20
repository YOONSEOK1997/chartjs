package com.example.chartjs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.chartjs.mapper.PlayerMapper;
import java.util.List;
import java.util.Map;

@RestController
public class PlayerRest {

    @Autowired
    private PlayerMapper playerMapper;

    @PostMapping("/rest/AvgAgeByCountry")
    public List<Map<String, Object>> getAvgAgeByCountry() {
        return playerMapper.selectAvgAgeByCountry();
    }

    @PostMapping("/rest/CountByGender")
    public List<Map<String, Object>> getCountByGender() {
        return playerMapper.selectCountByGender();
    }

    @PostMapping("/rest/CountByYearAndCountry")
    public List<Map<String, Object>> getCountByYearAndCountry() {
        return playerMapper.selectCountByYearAndCountry();
    }

    @PostMapping("/rest/TotalCountByYear")
    public List<Map<String, Object>> getTotalCountByYear() {
        return playerMapper.selectTotalCountByYear();
    }
}
