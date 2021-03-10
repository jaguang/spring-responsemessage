package id.bmri.induction.be.day2.beinductionday2.repository;

import id.bmri.induction.be.day2.beinductionday2.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments, Integer> {

    @Query(nativeQuery = true, value = "SELECT d.department_name,MAX(e.salary),Min(e.salary) FROM employees e JOIN departments d on e.department_id = d.department_id GROUP BY d.department_name")
     List<Object> findDepartmentsNameMaxMinSalary();

    @Query(nativeQuery = true, value = "SELECT d.DEPARTMENT_NAME Department, (e.FIRST_NAME || ' ' || e.LAST_NAME) Full_name FROM DEPARTMENTS d" +
            " FULL OUTER JOIN EMPLOYEES e ON d.DEPARTMENT_ID = e.DEPARTMENT_ID WHERE e.DEPARTMENT_ID IS NULL OR d.DEPARTMENT_ID IS NULL")
     List<Object> finEmployeeNullDepAndShowAll();


}
