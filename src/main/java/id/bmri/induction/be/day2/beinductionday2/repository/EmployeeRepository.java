package id.bmri.induction.be.day2.beinductionday2.repository;

import id.bmri.induction.be.day2.beinductionday2.entity.Employees;
import id.bmri.induction.be.day2.beinductionday2.response.DateJobResponse;
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

    @Query(nativeQuery = true, value = "SELECT e.first_name, e.last_name, e.email, h.start_date FROM employees e JOIN job_history h ON e.employee_id = h.employee_id")
    List<Object> findJoinStartDateJobHistory();

    @Query(nativeQuery = true, value = "SELECT j.job_title,COUNT(e.employee_id) FROM employees e RIGHT JOIN jobs j ON e.job_id = j.job_id GROUP BY j.job_title")
    List<Object> countEmployeesByJobTitle();

}
