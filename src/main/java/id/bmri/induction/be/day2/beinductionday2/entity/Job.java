package id.bmri.induction.be.day2.beinductionday2.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Job {

    @Id
    @Column
    private String jobId;

    @Column
    private String jobTitle;

    @Column
    private Integer minSalary;

    @Column
    private Integer maxSalary;

}
