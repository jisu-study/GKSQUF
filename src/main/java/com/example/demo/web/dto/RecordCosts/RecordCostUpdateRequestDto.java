package com.example.demo.web.dto.RecordCosts;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class RecordCostUpdateRequestDto {

    private String costCategory;
    private String costDetails;
    private BigDecimal costAmount;

    public RecordCostUpdateRequestDto(String costCategory, String costDetails, BigDecimal costAmount){
        this.costCategory = costCategory;
        this.costDetails = costDetails;
        this.costAmount = costAmount;
    }
}
