package com.example.demo.service;

import com.example.demo.domain.recordCosts.RecordCost;
import com.example.demo.domain.recordCosts.RecordCostRepository;
import com.example.demo.web.dto.RecordCosts.RecordCostAddRequestDto;
import com.example.demo.web.dto.RecordCosts.RecordCostResponseDto;
import com.example.demo.web.dto.RecordCosts.RecordCostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class RecordCostService {

    private final RecordCostRepository recordCostRepository;


    //비용표에 한 줄 추가
    @Transactional
    public RecordCostResponseDto addCost(RecordCostAddRequestDto recordCostAddRequestDto){
        RecordCost recordCost = new RecordCost(recordCostAddRequestDto);
        recordCostRepository.save(recordCost);

        //NotImplemented: 총합 계산하는 수식 들어가야함.
        BigDecimal sum = BigDecimal.valueOf(0);

        return new RecordCostResponseDto(recordCost, sum);
    }

    //한 줄의 내용 업데이트(지우고 다시 쓰기)
    @Transactional
    public RecordCostResponseDto updateCost(RecordCostUpdateRequestDto recordCostUpdateRequestDto, Integer cost_id){
        RecordCost recordCost = recordCostRepository.findById(cost_id)
                            .orElseThrow(()->new IllegalArgumentException("잘못된 접근 - 데이터가 존재하지 않습니다."));
        recordCost.update(recordCostUpdateRequestDto);

        //NotImplemented: 총합 계산하는 수식 들어가야함.
        BigDecimal sum = BigDecimal.valueOf(0);

        return new RecordCostResponseDto(recordCost, sum);
    }

    //한 줄의 내용 지우기
    @Transactional
    public void deleteCost(Integer cost_id){

        RecordCost recordCost = recordCostRepository.findById(cost_id)
                            .orElseThrow(()->new IllegalArgumentException("잘못된 접근 - 데이터가 존재하지 않습니다."));

        recordCostRepository.delete(recordCost);

        //CONCERN: ResponseDto 전달해야하나? sum 반영 때문에?
    }


}
