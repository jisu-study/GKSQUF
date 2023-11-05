package com.example.demo.web.dto.Records;

import com.example.demo.domain.records.Records;
import com.example.demo.web.dto.RecordContent.RecordContentSaveRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
public class RecordsSaveRequestDto {

    //private Cost costId;
    private String recordTitle;

    private String location;
    private Date startDate;
    private Date endDate;
    private List<RecordContentSaveRequestDto> recordContents;

    @Builder
    public RecordsSaveRequestDto(String recordTitle, String location, Date startDate, Date endDate){
        this.recordTitle = recordTitle;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public Records toEntity(){
        return Records.builder()
                .recordTitle(recordTitle)
                .location(location)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }

}
