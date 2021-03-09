package id.bmri.induction.be.day2.beinductionday2.repository;

import id.bmri.induction.be.day2.beinductionday2.entity.TransferTrx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferTrxRepository extends JpaRepository<TransferTrx, String> {

    <S extends TransferTrx> S save(S entity);

}
