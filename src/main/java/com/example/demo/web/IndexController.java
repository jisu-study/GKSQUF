package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "indexTest";
    }

    @GetMapping("/view_recordCosts")
    public String showViewRecordCosts(){
        return "cost_table";
    }

    @GetMapping("/view_record_list")
    public String showViewRecordList(){
        return "view_record_list";
    }

    @GetMapping("/view_detail_record") //나중에 view_record_detail로 바꾸고싶다
    public String showViewDetailRecord(){ //@RequestParam Long recordId, Model model 이거 없어도 되네?
        return "view_detail_record";
    }

    @GetMapping("/new_travel_record")
    public String newTravelRecord(){
        return "new_travel_record";
    }

    @GetMapping("/update_record")
    public String updateRecord(){
        return "update_record";
    }
}
