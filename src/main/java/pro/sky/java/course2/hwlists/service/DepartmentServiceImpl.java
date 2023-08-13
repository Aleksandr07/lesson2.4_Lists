package pro.sky.java.course2.hwlists.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.hwlists.domain.Employee;
import pro.sky.java.course2.hwlists.exceptions.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Integer findSumSalaryInDepartment(Integer department) {
        return employeeService.showEmployeeList().stream()
                .filter(employee -> employee.getDepartment() == department)
                .map(Employee::getSalary)
                .reduce(0, Integer::sum);
    }

    @Override
    public Integer findEmployeeWithMaxSalary(Integer department) {
        return employeeService.showEmployeeList().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .map(Employee::getSalary)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Integer findEmployeeWithMinSalary(Integer department) {
        return employeeService.showEmployeeList().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .map(Employee::getSalary)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> showAllEmployeesInDepartment(Integer department) {
            return employeeService.showEmployeeList().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());


    }

    @Override
    public Map<Integer, List<Employee>> showAllEmployees() {
        return employeeService.showEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
