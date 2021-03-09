package id.bmri.induction.be.day2.beinductionday2.controller;

import id.bmri.induction.be.day2.beinductionday2.entity.Employees;
import id.bmri.induction.be.day2.beinductionday2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employees> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/name")
    public Employees findFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployeeByFirstNameAndLastName(firstName,lastName);
    }

    @GetMapping("/job")
    public List<Employees> findEmployeesByJobIdAndMinSalary(@RequestParam String jobId,@RequestParam Integer salary) {
        return employeeService.findEmployeesByJobIdAndMinSalary(jobId,salary);
    }

    @GetMapping("/history")
    public List<Employees> findJoinStartDateJobHistory() {
        return employeeService.findJoinStartDateJobHistory();
    }
}
