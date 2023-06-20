package pro.sky.java.course2.hwlists.service;

import pro.sky.java.course2.hwlists.domain.Employee;

import java.util.ArrayList;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    Employee removeEmployee(Employee employee);

    Employee findEmployee(Employee employee);

    ArrayList<Employee> showEmployeeList();
}
