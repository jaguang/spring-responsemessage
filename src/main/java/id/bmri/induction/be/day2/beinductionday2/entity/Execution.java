package id.bmri.induction.be.day2.beinductionday2.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class Execution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "preparationId", nullable = false)
    private Preparation preparationId;

    @Column
    private Integer fromAccountNumber;

    @Column
    private Integer toAccountNumber;

    @Column
    private Integer amount;
}
