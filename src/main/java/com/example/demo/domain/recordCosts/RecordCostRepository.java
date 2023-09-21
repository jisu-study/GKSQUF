package com.example.demo.domain.recordCosts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RecordCostRepository extends JpaRepository<RecordCost, Long> {

    @Override
    Optional<RecordCost> findById(Long costId);     //id로 엔티티 찾기

    @Query("select rc from RecordCost rc where rc.records.recordId = :recordId")
    List<RecordCost> findAllByRecordId(@Param("recordId") Long recordId);           //Records의 id로 연관있는 모든 RecordCost 데이터 찾기


    //아직은 뭐가 더 들어가야 할 지 모르겠음...
}
