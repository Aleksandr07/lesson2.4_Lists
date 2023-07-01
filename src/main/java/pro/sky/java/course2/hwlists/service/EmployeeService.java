package pro.sky.java.course2.hwlists.service;

import pro.sky.java.course2.hwlists.domain.Employee;

import java.util.ArrayList;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    //ArrayList<Employee> showEmployeeList();
}
