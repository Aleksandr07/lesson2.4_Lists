package pro.sky.java.course2.hwlists.service;

import pro.sky.java.course2.hwlists.domain.Employee;


import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> showEmployeeList();
}
