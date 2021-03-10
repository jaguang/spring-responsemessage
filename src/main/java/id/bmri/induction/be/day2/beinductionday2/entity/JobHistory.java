package id.bmri.induction.be.day2.beinductionday2.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "job_history")
public class JobHistory {

    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "job_id")
    private String jobId;

    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "modified_date")
    private Timestamp modifiedDate;
}
