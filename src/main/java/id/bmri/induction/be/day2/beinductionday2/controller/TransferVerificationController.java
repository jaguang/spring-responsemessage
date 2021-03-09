package id.bmri.induction.be.day2.beinductionday2.controller;

import id.bmri.induction.be.day2.beinductionday2.entity.TransferStage;
import id.bmri.induction.be.day2.beinductionday2.entity.TransferVerification;
import id.bmri.induction.be.day2.beinductionday2.request.TransferVerificationRequest;
import id.bmri.induction.be.day2.beinductionday2.response.TransferVerificationResponse;
import id.bmri.induction.be.day2.beinductionday2.service.TransferStageService;
import id.bmri.induction.be.day2.beinductionday2.service.TransferVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/verification/v1/skn/provide")
public class TransferVerificationController {

    @Autowired
    TransferVerificationService transferVerificationService;

    @Autowired
    TransferStageService transferStageService;

    @PostMapping
    public TransferVerificationResponse verifactionTransactionId(@RequestBody TransferVerificationRequest request) {
        TransferVerificationResponse transferVerificationResponse = new TransferVerificationResponse();
        TransferVerification transferVerification = transferVerificationService.findByTransactionId(request.getTransactionId());
        TransferStage transferStage = transferStageService.findByTrasactionId(request.getTransactionId());
        if (transferVerification.getTransactionId().equals(transferStage.getTransactionId())) {
                transferVerification.setStatus("verified");
                transferVerificationService.save(transferVerification);
        }else {
            transferVerificationResponse.setStatus("Failed");
            return transferVerificationResponse;
        }

        transferVerificationResponse.setStatus("verified");
        return transferVerificationResponse;
    }
}
