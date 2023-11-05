package com.example.demo.web.dto.RecordContent;

import com.example.demo.domain.recordContents.RecordContent;
import com.example.demo.domain.records.Records;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class RecordContentSaveRequestDto {

    private Long recordId;
    private Date date;
    private String content;
    private String hashtag;

    @Builder
    public RecordContentSaveRequestDto(Long recordId, String content, String hashtag, Date date) {
        this.recordId = recordId;
        this.content = content;
        this.hashtag = hashtag;
        this.date = date;
    }

    public RecordContent toEntity(Records record) {
        return RecordContent.builder()
                .records(record)
                .date(date)
                .content(content)
                .hashtag(hashtag)
                .build();
    }

}
