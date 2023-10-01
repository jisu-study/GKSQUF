package com.example.demo.domain.recordCosts;

import com.example.demo.domain.records.Records;
import com.example.demo.web.dto.RecordCosts.RecordCostRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Entity
public class RecordCost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long costId;

    @Column(length = 255, nullable = false)
    private String costCategory;

    @Column(length = 255)
    private String costDetails;

    @Column
    private BigDecimal costAmount;     //DB에서는 decimal(8,2)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_id")
    private Records records;

    @Builder
    public RecordCost(String costCategory, String costDetails, BigDecimal costAmount, Records records){
        this.costCategory = costCategory;
        this.costDetails = costDetails;
        this.costAmount = costAmount;
        this.records = records;
    }


    public void update(RecordCostRequestDto recordCostRequestDto){
        this.costCategory = recordCostRequestDto.getCostCategory();
        this.costDetails = recordCostRequestDto.getCostDetails();
        this.costAmount = recordCostRequestDto.getCostAmount();
    }

}