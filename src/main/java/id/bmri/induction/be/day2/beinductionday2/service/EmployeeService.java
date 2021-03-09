package id.bmri.induction.be.day2.beinductionday2.service;

import id.bmri.induction.be.day2.beinductionday2.entity.Employees;
import id.bmri.induction.be.day2.beinductionday2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Optional<Employees> findByIdOptional(Integer id) {
        return employeeRepository.findById(id);
    }

    public List<Employees> findAll() {
        return employeeRepository.findAll();
    }

    public Employees findEmployeeByFirstNameAndLastName(String firstName,String lastName) {
        return employeeRepository.findEmployeesByFirstNameAndLastName(firstName,lastName);
    }

    public List<Employees> findEmployeesByJobIdAndMinSalary(String jobId,Integer salary) {
        return employeeRepository.findEmployeesByJobIdAndMinSalary(jobId,salary);
    }

    public List<Employees> findJoinStartDateJobHistory() {
        return employeeRepository.findJoinStartDateJobHistory();
    }


}
