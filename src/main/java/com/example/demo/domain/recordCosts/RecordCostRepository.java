package com.example.demo.domain.recordCosts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecordCostRepository extends JpaRepository<RecordCost, Integer> {

    @Override
    Optional<RecordCost> findById(Integer id);

    //아직은 뭐가 들어가야 할 지 모르겠음...
}
