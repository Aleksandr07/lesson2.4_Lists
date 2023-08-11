package pro.sky.java.course2.hwlists.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.hwlists.domain.Employee;
import pro.sky.java.course2.hwlists.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")

public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalary(@RequestParam Integer departmentId) {
        return departmentService.findEmployeeWithMaxSalary(departmentId);
    }


    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalary(@RequestParam Integer departmentId) {
        return departmentService.findEmployeeWithMinSalary(departmentId);
    }


    @GetMapping(value = "/all", params = {"departmentId"})
    public Collection<Employee> showAllEmployeesInDepartment(Integer departmentId) {
        return departmentService.showAllEmployees(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> showAllEmployeesInDepartment() {
        return departmentService.showAllEmployees();
    }


}
