package id.bmri.induction.be.day2.beinductionday2.repository;

import id.bmri.induction.be.day2.beinductionday2.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
}
