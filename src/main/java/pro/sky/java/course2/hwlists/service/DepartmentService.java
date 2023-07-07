package pro.sky.java.course2.hwlists.service;


import pro.sky.java.course2.hwlists.domain.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface DepartmentService {


    Employee findEmployeeWithMaxSalary(Integer department);

    Employee findEmployeeWithMinSalary(Integer department);

    Collection<Employee> showAllEmployees(Integer department);

    Map<Integer, List<Employee>> showAllEmployees();

}
