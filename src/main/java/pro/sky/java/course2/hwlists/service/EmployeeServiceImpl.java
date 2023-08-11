package pro.sky.java.course2.hwlists.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.hwlists.domain.Employee;
import pro.sky.java.course2.hwlists.exceptions.EmployeeAlreadyAddedException;
import pro.sky.java.course2.hwlists.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.hwlists.exceptions.InvalidEmployeeName;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer department, Integer salary) {
        checkInput(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(firstName + lastName)) {
            throw new EmployeeAlreadyAddedException("Работник уже существует");
        }
        employees.put(firstName + lastName, employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, Integer department, Integer salary) {
        checkInput(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (!employees.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException("Работник не найден");
        }
        employees.remove(firstName + lastName, employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, Integer department, Integer salary) {
        checkInput(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(firstName + lastName)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Работник не найден");
        }
    }

    @Override
    public Collection<Employee> showEmployeeList() {
        return employees.values();
    }

    private static void checkInput(String firstName, String lastName) throws InvalidEmployeeName{
        if (!(StringUtils.isAlpha(firstName) || StringUtils.isAlpha(lastName))) {
            throw new InvalidEmployeeName();
        }
    }


}
