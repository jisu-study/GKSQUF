package com.example.demo.web.dto.RecordCosts;

import com.example.demo.domain.recordCosts.RecordCost;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
public class RecordCostResponseDto {

    //비용 관련
    private final Integer cost_id;
    private final String cost_category;
    private final String cost_details;
    private final BigDecimal cost_amount;
    private final BigDecimal sum;

    public RecordCostResponseDto(RecordCost recordCost, BigDecimal sum){
        this.cost_id = recordCost.getCost_id();
        this.cost_category = recordCost.getCost_category();
        this.cost_details = recordCost.getCost_details();
        this.cost_amount = recordCost.getCost_amount();
        this.sum = sum;
    }



}
