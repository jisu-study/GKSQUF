package com.example.demo.domain.records;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Records {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;

    @Column(length = 255, nullable = false)
    private String recordTitle;

    @Column(nullable=false)
    private String location;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;


    @Builder
    public Records(Long recordId, String recordTitle, String location, Date startDate, Date endDate) {
        this.recordId = recordId;
        this.recordTitle = recordTitle;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void update(Long recordId,String recordTitle, String location, Date startDate, Date  endDate) {
        this.recordId = recordId;
        this.recordTitle = recordTitle;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
