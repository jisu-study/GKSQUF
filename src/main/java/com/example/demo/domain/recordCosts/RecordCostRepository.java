package com.example.demo.domain.recordCosts;

import com.example.demo.domain.records.Records;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface RecordCostRepository extends JpaRepository<RecordCost, Long> {

    @Override
    Optional<RecordCost> findById(Long costId);

    @Query("select rc from RecordCost rc where rc.record.recordId = :recordId")
    List<RecordCost> findAllByRecordId(@Param("recordId") Long recordId);

    //아직은 뭐가 들어가야 할 지 모르겠음...
}
