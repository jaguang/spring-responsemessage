package id.bmri.induction.be.day2.beinductionday2.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "transfer_verification")
public class TransferVerification {

    @Id
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "status")
    private String status;
}
