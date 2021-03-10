package id.bmri.induction.be.day2.beinductionday2.controller;

import id.bmri.induction.be.day2.beinductionday2.entity.JobHistory;
import id.bmri.induction.be.day2.beinductionday2.service.JobHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/job-history")
public class JobHistoryController {

    @Autowired
    JobHistoryService jobHistoryService;

    @PostMapping("/merge")
    public List<JobHistory> mergeModifiedDate() {
        return jobHistoryService.mergeModifiedDate();
    }
}
