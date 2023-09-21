package com.example.demo.domain.recordCosts;

import com.example.demo.domain.records.Records;
import com.example.demo.domain.records.RecordsPostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecordCostRepositoryTest {

    @Autowired
    RecordCostRepository recordCostRepository;

    @After      //단위 테스트가 끝날 때마다 수행되는 메소드
    public void cleanup(){
        recordCostRepository.deleteAll();
    }

    @Test
    public void recordId로_불러오기(){
        //given
        Long recordId = 1L;
        String costCategory = "식비";
        String costDetails = "감자탕";
        BigDecimal costAmount = BigDecimal.valueOf(32000);

        Records rd = Records.builder()
                            .recordTitle("RecordCostRepository Test")
                            .build();

        recordCostRepository.save(RecordCost.builder()
                                    .costCategory(costCategory)
                                    .costDetails(costDetails)
                                    .costAmount(costAmount)
                                    .records(rd)
                                    .build());

        //when
        List<RecordCost> recordCostList = recordCostRepository.findAllByRecordId(recordId);

        //then
        RecordCost recordCost = recordCostList.get(0);
        Assertions.assertThat(recordCost.getCostCategory()).isEqualTo(costCategory);
        Assertions.assertThat(recordCost.getCostDetails()).isEqualTo(costDetails);
//        Assertions.assertThat(recordCost.getCostAmount()).isEqualTo(costAmount);
//        Assertions.assertThat(recordCost.getRecords()).isEqualTo(rd);
    }

}
