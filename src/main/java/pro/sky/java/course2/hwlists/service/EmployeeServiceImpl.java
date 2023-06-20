package pro.sky.java.course2.hwlists.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.hwlists.domain.Employee;
import pro.sky.java.course2.hwlists.exceptions.EmployeeAlreadyAddedException;
import pro.sky.java.course2.hwlists.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.hwlists.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final ArrayList<Employee> employees;
    private int employees_count = 1;

    public EmployeeServiceImpl(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        int EMPLOYEES_SIZE = 5;
        if (employees_count > EMPLOYEES_SIZE) {
            throw new EmployeeStorageIsFullException();
        } else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.add(employee);
            employees_count++;
            return employee;
        }
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
            employees_count--;
            return employee;
        }
        throw new EmployeeNotFoundException();

    }

    @Override
    public Employee findEmployee(Employee employee) {
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public ArrayList<Employee> showEmployeeList() {
        return new ArrayList<>(employees);
    }
}
