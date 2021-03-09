package id.bmri.induction.be.day2.beinductionday2.repository;

import id.bmri.induction.be.day2.beinductionday2.entity.TransferStage;
import id.bmri.induction.be.day2.beinductionday2.entity.TransferVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferVerificationRepository extends JpaRepository<TransferVerification, String> {
    TransferVerification findByTransactionId(String Id);

//    <S extends TransferVerification> S save(S entity);
}
