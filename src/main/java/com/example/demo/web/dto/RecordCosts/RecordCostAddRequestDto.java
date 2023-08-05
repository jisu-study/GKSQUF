package com.example.demo.web.dto.RecordCosts;

import com.example.demo.domain.recordCosts.RecordCost;
import com.example.demo.domain.records.Records;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class RecordCostAddRequestDto {

    private String costCategory;
    private String costDetails;
    private BigDecimal costAmount;
    private Records record;

    public RecordCostAddRequestDto(String costCategory, String costDetails, BigDecimal costAmount, Records record){
        this.costCategory = costCategory;
        this.costDetails = costDetails;
        this.costAmount = costAmount;
        this.record = record;
    }

}
