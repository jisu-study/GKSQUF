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



    //비용표에 한 줄 추가
    @PostMapping("/api/v1/recordCosts")
    public String createCost(@RequestBody RecordCostRequestDto recordCostRequestDto){     //json기반의 메시지로 통신할 것이므로 @RequestBody

        recordCostService.createCost(recordCostRequestDto);
        return "redirect:/";
    }

    //한 줄의 내용 업데이트
    @PutMapping("/api/v1/recordCosts/{costId}")
    public String updateCost(@RequestBody RecordCostRequestDto recordCostRequestDto,
                                            @PathVariable Long costId){
        recordCostService.updateCost(recordCostRequestDto, costId);
        return "index";
    }

    //한 줄의 내용 지우기
    @DeleteMapping("/api/v1/recordCosts/{costId}")
    public void deleteCost(@PathVariable Long costId){
        recordCostService.deleteCost(costId);
    }

    //특정 records와 관련한 모든 recordCost 불러오기
    @GetMapping("/api/v1/records/{recordId}/recordCosts")
    public List<RecordCostResponseDto> list(@PathVariable("recordId") Long recordId){
        return recordCostService.findAll(recordId);
    }

}