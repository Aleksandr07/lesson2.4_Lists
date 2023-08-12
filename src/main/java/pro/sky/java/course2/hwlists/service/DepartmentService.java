package pro.sky.java.course2.hwlists.service;


import pro.sky.java.course2.hwlists.domain.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface DepartmentService {



    Integer findSumSalaryInDepartment(Integer department);

    Integer findEmployeeWithMaxSalary(Integer department);

    Integer findEmployeeWithMinSalary(Integer department);

    Collection<Employee> showAllEmployeesInDepartment(Integer department);

    Map<Integer, List<Employee>> showAllEmployees();

}
