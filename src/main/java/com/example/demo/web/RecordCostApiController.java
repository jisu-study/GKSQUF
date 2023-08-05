package com.example.demo.web;

import com.example.demo.domain.recordCosts.RecordCost;
import com.example.demo.service.RecordCostService;
import com.example.demo.web.dto.RecordCosts.RecordCostAddRequestDto;
import com.example.demo.web.dto.RecordCosts.RecordCostResponseDto;
import com.example.demo.web.dto.RecordCosts.RecordCostUpdateRequestDto;
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
    //CONCERN : 함수이름 addLine이 나은가...어떻게 지어도 얘가 뭐하는 함수인지 헷갈릴 것 같다.
    @PostMapping("/api/v1/recordCosts")
    public RecordCostResponseDto addCost(RecordCostAddRequestDto recordCostAddRequestDto){
        return recordCostService.addCost(recordCostAddRequestDto);
    }

    //한 줄의 내용 업데이트(지우고 다시 쓰기)
    @PutMapping("/api/v1/recordCosts/{costId}")
    public RecordCostResponseDto updateCost(RecordCostUpdateRequestDto recordCostUpdateRequestDto,
                                            @PathVariable Long costId){
        return recordCostService.updateCost(recordCostUpdateRequestDto, costId);
    }

    //한 줄의 내용 지우기
    @DeleteMapping("/api/v1/recordCosts/{costId}")
    public void deleteCost(@PathVariable Long costId){
        recordCostService.deleteCost(costId);
    }


    //특정 기록과 관련한 모든 줄 불러오기
    @GetMapping("/api/v1/records/{recordId}/recordCosts")
    public List<RecordCostResponseDto> findAll(@PathVariable("recordId") Long recordId){
        return recordCostService.findAll(recordId);
    }

}
