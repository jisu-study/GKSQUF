package com.example.demo.web;

import com.example.demo.domain.records.Records;
import com.example.demo.service.RecordsService;
import com.example.demo.web.dto.Records.RecordsSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecordsPostApiController {

    @Autowired
    private RecordsService recordsService;

    @GetMapping("/fetch-records")
    public List<Records> fetchAllRecords() {
        return recordsService.fetchAllRecords();
    }

    @GetMapping("/fetch-record/{recordId}")
    public Records fetchRecordById(@PathVariable Long recordId) {
        return recordsService.fetchRecordById(recordId);
    }


    @PostMapping("/add-record")
    public Long createRecord(@RequestBody RecordsSaveRequestDto requestDto) {
        return recordsService.save(requestDto);
    }


    @PutMapping("/update-record/{id}")
    public Long updateRecord(@PathVariable Long id, @RequestBody RecordsSaveRequestDto requestDto) {
        return recordsService.update(id, requestDto);
    }

    @DeleteMapping("/delete-record/{id}")
    public void deleteRecord(@PathVariable Long id) {
        recordsService.delete(id);
    }


}
