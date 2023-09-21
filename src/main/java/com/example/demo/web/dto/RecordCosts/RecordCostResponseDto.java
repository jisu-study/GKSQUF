package com.example.demo.web.dto.RecordCosts;

import com.example.demo.domain.recordCosts.RecordCost;
import com.example.demo.domain.records.Records;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class RecordCostResponseDto {

    //비용 관련
    private final Long costId;
    //private final Long recordId;
    private final String costCategory;
    private final String costDetails;
    private final BigDecimal costAmount;

    public RecordCostResponseDto(RecordCost recordCost){
        this.costId = recordCost.getCostId();
        //this.recordId = recordCost.getRecords().getRecordId();
        this.costCategory = recordCost.getCostCategory();
        this.costDetails = recordCost.getCostDetails();
        this.costAmount = recordCost.getCostAmount();
    }
}
