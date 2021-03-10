package id.bmri.induction.be.day2.beinductionday2.controller;

import id.bmri.induction.be.day2.beinductionday2.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("min-max")
    public List<Object> minMax() {
        return departmentService.findDepartmentsNameMaxMinSalary();
    }

    @GetMapping("name")
    public List<Object> departmentName() {
        return departmentService.finEmployeeNullDepAndShowAll();
    }
}
