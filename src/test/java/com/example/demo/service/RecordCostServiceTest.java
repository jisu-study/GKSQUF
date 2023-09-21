package com.example.demo.service;

import com.example.demo.domain.recordCosts.RecordCost;
import com.example.demo.domain.recordCosts.RecordCostRepository;
import com.example.demo.domain.records.RecordsPostsRepository;
import com.example.demo.web.dto.RecordCosts.RecordCostRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RecordCostServiceTest {

    @Autowired
    RecordCostRepository recordCostRepository;
    @Autowired
    RecordsPostsRepository recordsPostsRepository;
    @Autowired
    RecordCostService recordCostService;

    @After
    public void clear(){
        recordCostRepository.deleteAll();
        //recordsPostsRepository.deleteAll();
    }

    @Test
    void cost_생성하기() {

        //given
        String costCategory = "식비";
        String costDetails = "감자탕";
        BigDecimal costAmount = BigDecimal.valueOf(32000);

        RecordCostRequestDto recordCostRequestDto = RecordCostRequestDto.builder()
                .costCategory(costCategory)
                .costDetails(costDetails)
                .costAmount(costAmount)
                .build();

        //when
        recordCostService.createCost(recordCostRequestDto);

        //then
        List<RecordCost> recordCostList = recordCostRepository.findAll();
        RecordCost recordCost = recordCostList.get(0);
        System.out.println(recordCost);
        Assertions.assertThat(recordCost.getCostId()).isEqualTo(0L);
    }

    @Test
    void cost_업뎃하기() {
    }

    @Test
    void cost_삭제하기() {
    }

    @Test
    void recordId로_costs_찾기() {
    }
}