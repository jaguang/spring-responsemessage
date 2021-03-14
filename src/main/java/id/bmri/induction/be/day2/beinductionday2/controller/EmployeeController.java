package id.bmri.induction.be.day2.beinductionday2.controller;

import id.bmri.induction.be.day2.beinductionday2.entity.Employees;
import id.bmri.induction.be.day2.beinductionday2.entity.EmployeesDTO;
import id.bmri.induction.be.day2.beinductionday2.response.DateJobResponse;
import id.bmri.induction.be.day2.beinductionday2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/filter")
    public List<Employees> findAllFilter(@RequestParam Integer salary) {
        return employeeService.findAll().stream().filter(e -> e.getSalary() > salary).collect(Collectors.toList());
    }

    @GetMapping("/sorted")
    public List<Employees> findAllSort() {
        return employeeService.findAll().stream().sorted(Comparator.comparing(e -> e.getLastName())).collect(Collectors.toList());
    }

    @GetMapping("/filter-sorted")
    public List<Employees> findAllFilterSorted(@RequestParam Integer salary) {
        return employeeService.findAll().stream().filter(e -> e.getSalary() > salary).sorted().collect(Collectors.toList());
    }

    @GetMapping("/fullname")
    public List<EmployeesDTO> findAllStream() {
        return employeeService.findAll().stream().map(e -> EmployeesDTO.builder()
        .fullName(e.getFirstName()+ " " + e.getLastName())
                .build()).collect(Collectors.toList());
    }

    @GetMapping("/findFirst")
    public Employees findFirst(@RequestParam Integer salary) {
        return employeeService.findAll().stream().filter(e -> e.getSalary() > salary).findFirst().get();
    }

    @GetMapping("/anymatch")
    public Boolean anymatch() {
        return employeeService.findAll().stream().anyMatch(e -> e.getSalary() == null);
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
    public List<Object> findJoinStartDateJobHistory() {
        return employeeService.findJoinStartDateJobHistory();
    }

    @GetMapping("/count")
    public List<Object> count() {
        return employeeService.countEmployeesByJobTitle();
    }

    @PostMapping("update")
    public Employees add(@RequestParam Employees employees) {
        return employeeService.save(employees);
    }

    @DeleteMapping("delete")
    public Employees delete(@RequestParam Integer id) {
        return employeeService.delete(id);
    }
}
