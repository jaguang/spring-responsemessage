package id.bmri.induction.be.day2.beinductionday2.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Countries {

    @Id
    @Column
    private String countryId;

    @Column
    private String countryName;

    @Column
    private Integer number;

}
