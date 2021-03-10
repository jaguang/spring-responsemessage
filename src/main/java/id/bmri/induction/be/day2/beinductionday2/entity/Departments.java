package id.bmri.induction.be.day2.beinductionday2.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Departments {

    @Id
    @Column
    private Integer departmentId;

    @Column
    private String departmentName;

    @Column
    private Integer managerId;

    @Column
    private Integer locationId;

}
