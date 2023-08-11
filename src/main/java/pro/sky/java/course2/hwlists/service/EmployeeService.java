package pro.sky.java.course2.hwlists.service;

import pro.sky.java.course2.hwlists.domain.Employee;


import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, Integer department, Integer salary);

    Employee removeEmployee(String firstName, String lastName, Integer department, Integer salary);

    Employee findEmployee(String firstName, String lastName, Integer department, Integer salary);

    Collection<Employee> showEmployeeList();
}
