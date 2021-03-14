package id.bmri.induction.be.day2.beinductionday2.repository;

import id.bmri.induction.be.day2.beinductionday2.entity.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionsRepository extends JpaRepository<Regions, Integer> {
}
