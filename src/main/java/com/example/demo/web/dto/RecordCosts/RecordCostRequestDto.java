package com.example.demo.web.dto.RecordCosts;

import com.example.demo.domain.recordCosts.RecordCost;
import com.example.demo.domain.records.Records;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class RecordCostRequestDto {

    //update시 필요
    private Long costId;
    private Long recordId;

    //create+update 공통 요소
    private String costCategory;
    private String costDetails;
    private BigDecimal costAmount;




    /*
        use to UPDATE
    */
    @Builder
    public RecordCostRequestDto(Long costId, Long recordId, String costCategory, String costDetails, BigDecimal costAmount){
        this.costId = costId;
        this.recordId = recordId;
        this.costCategory = costCategory;
        this.costDetails = costDetails;
        this.costAmount = costAmount;
    }



    /*
        use to CREATE
     */
    @Builder
    public RecordCostRequestDto(String costCategory, String costDetails, BigDecimal costAmount){
        this.costCategory = costCategory;
        this.costDetails = costDetails;
        this.costAmount = costAmount;
    }

    public RecordCost toEntity(Records records){
        return RecordCost.builder()
                .costCategory(costCategory)
                .costDetails(costDetails)
                .costAmount(costAmount)
                .records(records)
                .build();
    }
}
