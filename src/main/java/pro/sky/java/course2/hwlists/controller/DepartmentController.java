package pro.sky.java.course2.hwlists.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.hwlists.domain.Employee;
import pro.sky.java.course2.hwlists.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")

public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/salary/sum")
    public Integer findSumSalaryInDepartment(@PathVariable Integer id) {
        return departmentService.findSumSalaryInDepartment(id);
    }

    @GetMapping("/{id}/salary/max")
    public Integer findEmployeeWithMaxSalary(@PathVariable Integer id) {
        return departmentService.findEmployeeWithMaxSalary(id);
    }


    @GetMapping("/{id}/salary/min")
    public Integer findEmployeeWithMinSalary(@PathVariable Integer id) {
        return departmentService.findEmployeeWithMinSalary(id);
    }


    @GetMapping("/{id}/employees")
    public Collection<Employee> showAllEmployeesInDepartment(@PathVariable Integer id) {
        return departmentService.showAllEmployeesInDepartment(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> showAllEmployees() {
        return departmentService.showAllEmployees();
    }


}
