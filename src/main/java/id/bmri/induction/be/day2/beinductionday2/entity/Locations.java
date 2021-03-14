package id.bmri.induction.be.day2.beinductionday2.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table
public class Locations {

    @Id
    @Column
    private Integer locationId;

    @Column
    private String streetAddress;

    @Column
    private String postalCode;

    @Column
    private String city;

    @Column
    private String stateProvince;

    @Column
    private String countryId;

    @Column
    private Timestamp dateModif;


}
