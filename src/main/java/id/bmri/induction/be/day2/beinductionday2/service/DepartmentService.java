package id.bmri.induction.be.day2.beinductionday2.service;

import id.bmri.induction.be.day2.beinductionday2.entity.Departments;
import id.bmri.induction.be.day2.beinductionday2.entity.Employees;
import id.bmri.induction.be.day2.beinductionday2.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Object> findDepartmentsNameMaxMinSalary() {
        return departmentRepository.findDepartmentsNameMaxMinSalary();
    }

    public List<Object> finEmployeeNullDepAndShowAll() {
        return departmentRepository.finEmployeeNullDepAndShowAll();
    }

    public Departments findById(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Departments delete(Integer id) {
        Departments entity = findById(id);
        if(entity != null) {
            departmentRepository.findById(id);
            return entity;
        } else {
            return null;
        }
    }

    public Departments save(Departments entity) {
        return departmentRepository.save(entity);
    }
}
