package com.example.demo.web;

import com.example.demo.service.RecordCostService;
import com.example.demo.web.dto.RecordCosts.RecordCostRequestDto;
import com.example.demo.web.dto.RecordCosts.RecordCostResponseDto;
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
        return "redirect:/";
    }

    //update recordCost
    @PutMapping("/recordCosts")
    public String updateCost(@RequestBody RecordCostRequestDto recordCostRequestDto){
        recordCostService.updateCost(recordCostRequestDto);
        return "index";
    }

    //delete recordCost
    @DeleteMapping("/recordCosts/{costId}")
    public void deleteCost(@PathVariable Long costId){
        recordCostService.deleteCost(costId);
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
    @GetMapping("/records/{recordId}/recordCosts")
    public List<RecordCostResponseDto> findByRecordId(@PathVariable("recordId") Long recordId){
        return recordCostService.findByRecordId(recordId);
    }

}