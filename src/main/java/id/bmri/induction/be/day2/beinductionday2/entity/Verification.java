package id.bmri.induction.be.day2.beinductionday2.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class Verification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "preparation_id",nullable = false)
    private Preparation preparationId;

    @Column
    private Boolean status;
}
