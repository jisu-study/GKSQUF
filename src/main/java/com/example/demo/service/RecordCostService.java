package com.example.demo.service;

import com.example.demo.domain.recordCosts.RecordCost;
import com.example.demo.domain.recordCosts.RecordCostRepository;
import com.example.demo.domain.records.Records;
import com.example.demo.domain.records.RecordsPostsRepository;
import com.example.demo.web.dto.RecordCosts.RecordCostRequestDto;
import com.example.demo.web.dto.RecordCosts.RecordCostResponseDto;
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
    private final RecordsPostsRepository recordsPostsRepository;


    @Transactional
    public Long createCost(RecordCostRequestDto recordCostRequestDto){

        //check: dto의 costId가 null값이어야함.
        if(recordCostRequestDto.getCostId() != null){
            throw new IllegalArgumentException("생성 오류 - costId가 이미 생성되어 있습니다.");
        }

//        Records records = recordsPostsRepository.findById(recordCostRequestDto.getRecordId())
//                .orElseThrow(()-> new IllegalArgumentException("생성 오류 - 존재하지 않은 recordId를 전달받았습니다."));

        Records records = recordsPostsRepository.findById(Long.valueOf(71))
                .orElseThrow(() -> new IllegalArgumentException("몬가...잘못됨..."));

        //create
        RecordCost recordCost = recordCostRequestDto.toEntity(records);
        return recordCostRepository.save(recordCost).getCostId();               //CONCERN: 혹시 나중에 쓰일까봐 일단 costId를 반환하도록 해놨음.
    }

    @Transactional
    public void updateCost(RecordCostRequestDto recordCostRequestDto){

        //check: dto의 costId로 데이터 찾기
        RecordCost recordCost = recordCostRepository.findById(recordCostRequestDto.getCostId())
                            .orElseThrow(()->new IllegalArgumentException("업데이트 오류 - 해당 costId를 가진 데이터가 존재하지 않습니다."));

        //update
        recordCost.update(recordCostRequestDto);
    }

    @Transactional
    public void deleteCost(Long costId){

        //check: costId로 데이터 찾기
        RecordCost recordCost = recordCostRepository.findById(costId)
                            .orElseThrow(()->new IllegalArgumentException("삭제 오류 - 해당 costId를 가진 데이터가 존재하지 않습니다."));

        //delete
        recordCostRepository.delete(recordCost);
    }


    @Transactional(readOnly = true)
    public RecordCostResponseDto getCost(Long costId){

        //check: costId로 데이터 찾기
        RecordCost recordCost = recordCostRepository.findById(costId)
                .orElseThrow(()->new IllegalArgumentException("불러오기 오류 - 해당 costId를 가진 데이터가 존재하지 않습니다."));

        //get
        return new RecordCostResponseDto(recordCost);
    }

    @Transactional(readOnly = true)
    public List<RecordCostResponseDto> findByRecordId(Long recordId){

        //find: recordId로 관련 Cost 데이터 찾기
        List<RecordCost> recordCostList = recordCostRepository.findAllByRecordId(recordId);

        //list
        List<RecordCostResponseDto> responseDtoList = new ArrayList<>();
        for(RecordCost rc: recordCostList) {
           responseDtoList.add(new RecordCostResponseDto(rc));
        }

        return responseDtoList;
    }
}
