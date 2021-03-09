package id.bmri.induction.be.day2.beinductionday2.repository;

import id.bmri.induction.be.day2.beinductionday2.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

    @Override
    Optional<Employees> findById(Integer Id);

    Employees findEmployeesByFirstNameAndLastName(String firstName, String lastName);

    @Query(nativeQuery = true, value = "select * from employees e where e.job_id =:jobId and e.salary >:minSalary")
    List<Employees> findEmployeesByJobIdAndMinSalary(String jobId, Integer minSalary);

    @Query(nativeQuery = true, value = "select e.first_name, e.last_name, e.email, h.start_date from employees e join job_history h on e.employee_id = h.employee_id")
    List<Employees> findJoinStartDateJobHistory();
}
