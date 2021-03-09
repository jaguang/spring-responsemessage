package id.bmri.induction.be.day2.beinductionday2.controller;

import id.bmri.induction.be.day2.beinductionday2.entity.TransferStage;
import id.bmri.induction.be.day2.beinductionday2.entity.TransferTrx;
import id.bmri.induction.be.day2.beinductionday2.entity.TransferVerification;
import id.bmri.induction.be.day2.beinductionday2.request.TransferTrxRequest;
import id.bmri.induction.be.day2.beinductionday2.service.TransferStageService;
import id.bmri.induction.be.day2.beinductionday2.service.TransferTrxService;
import id.bmri.induction.be.day2.beinductionday2.service.TransferVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer/v1/skn/execution")
public class TransferTrxController {

    @Autowired
    TransferStageService transferStageService;

    @Autowired
    TransferTrxService transferTrxService;

    @Autowired
    TransferVerificationService transferVerificationService;

    @PostMapping
    public String addExecution(@RequestBody TransferTrxRequest request) {
        TransferVerification transferVerification = transferVerificationService.findByTransactionId(request.getTransactionId());
        if(transferVerification.getStatus().equals("verified")){
            TransferStage transferStage = transferStageService.findByTrasactionId(request.getTransactionId());
            TransferTrx transferTrx = new TransferTrx();
            transferTrx.setTransactionId(transferStage.getTransactionId());
            transferTrx.setFromAccountNumber(transferStage.getFromAccountNumber());
            transferTrx.setAmount(transferStage.getAmount());
            transferTrx.setToAccountNumber(transferStage.getToAccountNumber());
            transferTrxService.save(transferTrx);
        } else {
            return "Transfer Failed";
        }
        return "Transfer Success";
    }
}
