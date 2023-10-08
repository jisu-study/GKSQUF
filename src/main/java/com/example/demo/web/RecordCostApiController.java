package com.example.demo.web;

import com.example.demo.service.RecordCostService;
import com.example.demo.web.dto.RecordCosts.RecordCostRequestDto;
import com.example.demo.web.dto.RecordCosts.RecordCostResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RecordCostApiController {

    private final RecordCostService recordCostService;

    @Autowired
    public RecordCostApiController(RecordCostService recordCostService){
        this.recordCostService = recordCostService;
    }



    //create recordCost
    @PostMapping("/recordCosts")
    public String createCost(@RequestBody RecordCostRequestDto recordCostRequestDto){     //json기반의 메시지로 통신할 것이므로 @RequestBody

        recordCostService.createCost(recordCostRequestDto);
        return "cost_table";
    }

    //update recordCost
    @PutMapping("/recordCosts")
    public String updateCost(@RequestBody RecordCostRequestDto recordCostRequestDto){
        recordCostService.updateCost(recordCostRequestDto);
        return "cost_table";
    }

    //delete recordCost
    @DeleteMapping("/recordCosts/{costId}")
    @ResponseBody
    public Long deleteCost(@PathVariable Long costId){
        recordCostService.deleteCost(costId);

        return costId;
    }





    /*
        데이터 조회 메소드
     */

    //costId로 특정 recordCost 불러오기
    @GetMapping("/recordCosts/{costId}")
    public RecordCostResponseDto getCost(@PathVariable Long costId){
        return recordCostService.getCost(costId);
    }

    //특정 records와 관련한 모든 recordCost 불러오기
    @GetMapping("/records/recordCosts")
    @ResponseBody
    public String findByRecordId(@RequestParam Long recordId) throws JsonProcessingException {

        List<RecordCostResponseDto> responseDtos = recordCostService.findByRecordId(recordId);

        //jackson ObjectMapper 객체 생성
        ObjectMapper objectMapper = new ObjectMapper();

        //배열 -> JSON 형식의 '문자열'
        return objectMapper.writeValueAsString(responseDtos);
    }

}