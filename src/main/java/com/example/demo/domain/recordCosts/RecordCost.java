package com.example.demo.domain.recordCosts;

import com.example.demo.domain.records.Records;
import com.example.demo.web.dto.RecordCosts.RecordCostAddRequestDto;
import com.example.demo.web.dto.RecordCosts.RecordCostUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @Column(length = 255, nullable = true)
    private String costDetails;

    @Column(nullable = true)
    private BigDecimal costAmount;     //sql-money == java-BigDecimal

    @ManyToOne
    @JoinColumn(name = "record_id")
    private Records record;

    @Builder
    public RecordCost(RecordCostAddRequestDto recordCostAddRequestDto){
        this.costCategory = recordCostAddRequestDto.getCostCategory();
        this.costDetails = recordCostAddRequestDto.getCostDetails();
        this.costAmount = recordCostAddRequestDto.getCostAmount();
        this.record = recordCostAddRequestDto.getRecord();
    }


    public void update(RecordCostUpdateRequestDto recordCostUpdateRequestDto){
        this.costCategory = recordCostUpdateRequestDto.getCostCategory();
        this.costDetails = recordCostUpdateRequestDto.getCostDetails();
        this.costAmount = recordCostUpdateRequestDto.getCostAmount();
    }

}
