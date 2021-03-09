package id.bmri.induction.be.day2.beinductionday2.service;

import id.bmri.induction.be.day2.beinductionday2.entity.TransferVerification;
import id.bmri.induction.be.day2.beinductionday2.repository.TransferVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferVerificationService {

    @Autowired
    TransferVerificationRepository transferVerificationRepository;

    public TransferVerification findByTransactionId(String Id) {
        return transferVerificationRepository.findByTransactionId(Id);
    }

    public TransferVerification save(TransferVerification transferVerification) {
        return transferVerificationRepository.save(transferVerification);
    }
}
