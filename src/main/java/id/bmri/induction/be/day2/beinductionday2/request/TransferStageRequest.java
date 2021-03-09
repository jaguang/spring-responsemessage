package id.bmri.induction.be.day2.beinductionday2.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferStageRequest {

    private String fromAccountNumber;

    private String toAccountNumber;

    private Integer amount;
}
