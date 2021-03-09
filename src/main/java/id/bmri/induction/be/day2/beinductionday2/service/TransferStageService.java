package id.bmri.induction.be.day2.beinductionday2.service;

import id.bmri.induction.be.day2.beinductionday2.entity.TransferStage;
import id.bmri.induction.be.day2.beinductionday2.repository.TransferStageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferStageService {

    @Autowired
    TransferStageRepository transferStageRepository;

    public TransferStage addTransaction(TransferStage request) {
        return transferStageRepository.save(request);
    }

    public List<TransferStage> findAll() {
        return transferStageRepository.findAll();
    }

    public TransferStage findByTrasactionId(String id) {
        return transferStageRepository.findByTransactionId(id);
    }
}
