package id.bmri.induction.be.day2.beinductionday2.service;

import id.bmri.induction.be.day2.beinductionday2.entity.Employees;
import id.bmri.induction.be.day2.beinductionday2.repository.EmployeeRepository;
import id.bmri.induction.be.day2.beinductionday2.response.DateJobResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.swing.text.html.parser.Entity;
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

    public List<Object> findJoinStartDateJobHistory() {
        return employeeRepository.findJoinStartDateJobHistory();
    }

    public List<Object> countEmployeesByJobTitle() {
        return employeeRepository.countEmployeesByJobTitle();
    }

    public Employees findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employees delete(Integer id) {
        Employees entity = findById(id);
        if(entity != null) {
            employeeRepository.deleteById(id);
            return entity;
        } else {
            return null;
        }
    }

    public Employees update(Integer id,Employees entity) {
        Employees employees = findById(id);
        if(employees != null) {
            return employeeRepository.save(employees);
        } else {
            return null;
        }
    }

    public Employees save(Employees entity) {
        return employeeRepository.save(entity);
    }

}
