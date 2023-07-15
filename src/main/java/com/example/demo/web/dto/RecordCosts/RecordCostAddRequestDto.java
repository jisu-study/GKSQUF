package com.example.demo.web.dto.RecordCosts;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class RecordCostAddRequestDto {

    private String cost_category;
    private String cost_details;
    private BigDecimal cost_amount;

    public RecordCostAddRequestDto(String cost_category, String cost_details, BigDecimal cost_amount){
        this.cost_category = cost_category;
        this.cost_details = cost_details;
        this.cost_amount = cost_amount;
    }

}
