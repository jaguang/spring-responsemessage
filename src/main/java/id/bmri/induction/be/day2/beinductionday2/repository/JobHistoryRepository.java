package id.bmri.induction.be.day2.beinductionday2.repository;

import id.bmri.induction.be.day2.beinductionday2.entity.Employees;
import id.bmri.induction.be.day2.beinductionday2.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, Integer> {

    @Modifying
    @Query(nativeQuery = true, value = "MERGE INTO job_history h" +
            "    USING (SELECT * FROM employees) e" +
            "    ON (h.employee_id = e.employee_id)" +
            "    WHEN MATCHED then " +
            "    UPDATE SET modified_date = current_timestamp " +
            "    WHEN NOT MATCHED THEN " +
            "    INSERT (employee_id, start_date, end_date, job_id, department_id, modified_date)" +
            "    VALUES (e.employee_id, TO_DATE('01-01-2010', 'DD-MM-YYYY'), sysdate, e.job_id, e.department_id, current_timestamp(9))")
    Integer mergeModifiedDate();


}
