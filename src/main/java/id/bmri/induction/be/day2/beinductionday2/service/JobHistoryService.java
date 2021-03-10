package id.bmri.induction.be.day2.beinductionday2.service;

import id.bmri.induction.be.day2.beinductionday2.entity.Departments;
import id.bmri.induction.be.day2.beinductionday2.entity.Employees;
import id.bmri.induction.be.day2.beinductionday2.entity.JobHistory;
import id.bmri.induction.be.day2.beinductionday2.repository.JobHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobHistoryService {

    @Autowired
    JobHistoryRepository jobHistoryRepository;

    public List<JobHistory> mergeModifiedDate() {
        return jobHistoryRepository.mergeModifiedDate();
    }
    public JobHistory findById(Integer id) {
        return jobHistoryRepository.findById(id).orElse(null);
    }

    public JobHistory delete(Integer id) {
        JobHistory entity = findById(id);
        if(entity != null) {
            jobHistoryRepository.findById(id);
            return entity;
        } else {
            return null;
        }
    }

    public JobHistory save(JobHistory entity) {
        return jobHistoryRepository.save(entity);
    }
}
