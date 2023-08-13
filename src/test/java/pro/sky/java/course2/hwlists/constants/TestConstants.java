package pro.sky.java.course2.hwlists.constants;

import pro.sky.java.course2.hwlists.domain.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestConstants {
    public static final String FIRST_NAME_1 = "Иван";
    public static final String LAST_NAME_1 = "Иванов";

    public static final String INVALID_FIRST_NAME_1 = "Иван123";
    public static final String FIRST_NAME_2 = "Петр";
    public static final String LAST_NAME_2 = "Петров";
    public static final String FIRST_NAME_3 = "Степан";
    public static final String LAST_NAME_3 = "Степанов";

    public static final int DEPARTMENT_ID_1 = 1;
    public static final int DEPARTMENT_ID_2 = 1;
    public static final int DEPARTMENT_ID_3 = 2;
    public static final int SALARY_1 = 1000;
    public static final int SALARY_2 = 100;
    public static final int SALARY_3 = 200;

    public static final Employee FIRST_EMPLOYEE = new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_ID_1, SALARY_1);
    public static final Employee SECOND_EMPLOYEE = new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_ID_2, SALARY_2);
    public static final Employee THIRD_EMPLOYEE = new Employee(FIRST_NAME_3, LAST_NAME_3, DEPARTMENT_ID_3, SALARY_3);

    public static final List<Employee> EMPLOYEE_LIST = List.of(FIRST_EMPLOYEE, SECOND_EMPLOYEE, THIRD_EMPLOYEE);
    public static final List<Employee> EMPLOYEE_LIST_DEPARTMENT_1 = List.of(FIRST_EMPLOYEE, SECOND_EMPLOYEE);
    public static final int MAX_SALARY = SALARY_1 + SALARY_2;
    public static final Map<Integer, List<Employee>> EMPLOYEES_BY_DEPARTMENT = EMPLOYEE_LIST.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));

}
