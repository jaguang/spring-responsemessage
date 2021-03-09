package id.bmri.induction.be.day2.beinductionday2.service;

import id.bmri.induction.be.day2.beinductionday2.entity.TransferTrx;
import id.bmri.induction.be.day2.beinductionday2.repository.TransferTrxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferTrxService {

    @Autowired
    TransferTrxRepository transferTrxRepository;

    public TransferTrx save(TransferTrx transferTrx) {
        return transferTrxRepository.save(transferTrx);
    }
}
