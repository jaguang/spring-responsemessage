package id.bmri.induction.be.day2.beinductionday2.repository;

import id.bmri.induction.be.day2.beinductionday2.entity.TransferStage;
import id.bmri.induction.be.day2.beinductionday2.entity.TransferTrx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferStageRepository extends JpaRepository<TransferStage, String> {

    TransferStage findByTransactionId(String id);

    <S extends TransferStage> S save(S entity);

}
