package com.example.demo.domain.recordCosts;

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
    private Integer cost_id;

    @Column(length = 255, nullable = false)
    private String cost_category;

    @Column(length = 255, nullable = true)
    private String cost_details;

    @Column(nullable = true)
    private BigDecimal cost_amount;     //sql-money == java-BigDecimal


    @Builder
    public RecordCost(RecordCostAddRequestDto recordCostAddRequestDto){
        this.cost_category = recordCostAddRequestDto.getCost_category();
        this.cost_details = recordCostAddRequestDto.getCost_details();
        this.cost_amount = recordCostAddRequestDto.getCost_amount();
    }


    public void update(RecordCostUpdateRequestDto recordCostUpdateRequestDto){
        this.cost_category = recordCostUpdateRequestDto.getCost_category();
        this.cost_details = recordCostUpdateRequestDto.getCost_details();
        this.cost_amount = recordCostUpdateRequestDto.getCost_amount();
    }

}
