package com.example.demo.web.dto.Records;

import com.example.demo.domain.recordCosts.RecordCost;
import com.example.demo.domain.records.Records;
import lombok.Getter;

import java.util.Date;

@Getter
public class RecordsResponseDto {

    // private final int cost; // cost 부분은 따로 수정
    private long recordId;
    private RecordCost cost_id;
    private String recordTitle;
    private String location;
    private Date startDate;
    private Date endDate;

    public RecordsResponseDto(Records entity) {
        this.recordId =entity.getRecordId();
        // this.cost = entity.getCost();
        this.recordTitle = entity.getRecordTitle();
        this.location = entity.getLocation();
        this.startDate = entity.getStartDate();
        this.endDate = entity.getEndDate();
    }
}
