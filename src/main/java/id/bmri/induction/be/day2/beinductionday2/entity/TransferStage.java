package id.bmri.induction.be.day2.beinductionday2.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "transfer_stage")
public class TransferStage {

    @Id
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "from_account_number")
    private String fromAccountNumber;

    @Column(name = "to_account_number")
    private String toAccountNumber;

    @Column(name = "amount")
    private Integer amount;
}
