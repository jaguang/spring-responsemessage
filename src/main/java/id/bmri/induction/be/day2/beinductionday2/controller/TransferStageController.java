package id.bmri.induction.be.day2.beinductionday2.controller;

import id.bmri.induction.be.day2.beinductionday2.entity.TransferStage;
import id.bmri.induction.be.day2.beinductionday2.entity.TransferVerification;
import id.bmri.induction.be.day2.beinductionday2.request.TransferStageRequest;
import id.bmri.induction.be.day2.beinductionday2.response.TransferStageResponse;
import id.bmri.induction.be.day2.beinductionday2.service.TransferStageService;
import id.bmri.induction.be.day2.beinductionday2.service.TransferVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transfer/v1/skn/preparation")
public class TransferStageController {

    @Autowired
    TransferStageService transferStageService;

    @Autowired
    TransferVerificationService transferVerificationService;


    @PostMapping
    public TransferStageResponse addPreparation(@RequestBody TransferStageRequest request) {
        TransferStage transferStage = new TransferStage();
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        transferStage.setFromAccountNumber(request.getFromAccountNumber());
        transferStage.setToAccountNumber(request.getToAccountNumber());
        transferStage.setAmount(request.getAmount());
        transferStage.setTransactionId(uuidAsString);
        transferStageService.addTransaction(transferStage);
        TransferVerification transferVerification = new TransferVerification();
        transferVerification.setTransactionId(uuidAsString);
        transferVerificationService.save(transferVerification);

        TransferStageResponse preparationRequest = new TransferStageResponse();
        preparationRequest.setTransactionId(transferStage.getTransactionId());

        return preparationRequest;
    }

    @GetMapping("/all")
    public List<TransferStage> findAllTransferStage() {
        return transferStageService.findAll();
    }
}
