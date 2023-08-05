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
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RecordCostService {

    private final RecordCostRepository recordCostRepository;


    //비용표에 한 줄 추가
    @Transactional
    public RecordCostResponseDto addCost(RecordCostAddRequestDto recordCostAddRequestDto){
        RecordCost recordCost = new RecordCost(recordCostAddRequestDto);
        recordCostRepository.save(recordCost);

        //TODO : 총합 계산하는 수식 들어가야함.
        BigDecimal sum = BigDecimal.valueOf(0);

        return new RecordCostResponseDto(recordCost, sum);
    }

    //한 줄의 내용 업데이트(지우고 다시 쓰기)
    @Transactional
    public RecordCostResponseDto updateCost(RecordCostUpdateRequestDto recordCostUpdateRequestDto, Long costId){
        RecordCost recordCost = recordCostRepository.findById(costId)
                            .orElseThrow(()->new IllegalArgumentException("잘못된 접근 - 데이터가 존재하지 않습니다."));
        recordCost.update(recordCostUpdateRequestDto);

        //TODO : 총합 계산하는 수식 들어가야함.
        BigDecimal sum = BigDecimal.valueOf(0);

        return new RecordCostResponseDto(recordCost, sum);
    }

    //한 줄의 내용 지우기
    @Transactional
    public void deleteCost(Long costId){

        RecordCost recordCost = recordCostRepository.findById(costId)
                            .orElseThrow(()->new IllegalArgumentException("잘못된 접근 - 데이터가 존재하지 않습니다."));

        recordCostRepository.delete(recordCost);

        //CONCERN : ResponseDto 전달해야하나? sum 반영 때문에?
    }
    
    //특정 기록과 관련한 모든 줄 불러오기
    //CONCERN : 리턴 형식...DTO LIST? 그냥 ENTITY LIST?
    // - 일단 다른 함수들과 리턴 형식 통일하려고 DTO 리스트로 리턴하긴 했는데, 불필요해보이긴함...
    //TODO : 아예 미구현 함수
    @Transactional(readOnly = true)
    public List<RecordCostResponseDto> findAll(Long recordId){

        List<RecordCostResponseDto> costDTOList = new ArrayList<>();

        List<RecordCost> costList = recordCostRepository.findAllByRecordId(recordId);

        //problem : sum 어쩌지...?

        return costDTOList;
    }
}
