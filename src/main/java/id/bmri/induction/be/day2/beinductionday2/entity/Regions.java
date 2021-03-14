package id.bmri.induction.be.day2.beinductionday2.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Regions {

    @Id
    private Integer regionId;

    @Column
    private String regionName;
}
