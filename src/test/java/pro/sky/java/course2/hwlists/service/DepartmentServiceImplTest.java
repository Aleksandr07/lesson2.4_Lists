package pro.sky.java.course2.hwlists.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.hwlists.exceptions.EmployeeNotFoundException;

import java.util.Collections;


import static pro.sky.java.course2.hwlists.constants.TestConstants.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void shouldFindSumSalaryInDepartment() {
        when(employeeService.showEmployeeList()).thenReturn(EMPLOYEE_LIST);
        assertEquals(MAX_SALARY, departmentService.findSumSalaryInDepartment(DEPARTMENT_ID_1));
    }

    @Test
    public void shouldFindEmployeeWithMaxSalary() {
        when(employeeService.showEmployeeList()).thenReturn(EMPLOYEE_LIST);
        assertEquals(SALARY_1, departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID_1));
    }

    @Test
    public void shouldFindEmployeeWithMinSalary() {
        when(employeeService.showEmployeeList()).thenReturn(EMPLOYEE_LIST);
        assertEquals(SALARY_2, departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID_1));
    }

    @Test
    public void shouldThrowEmployeeNotFoundException() {
        when(employeeService.showEmployeeList()).thenReturn(Collections.emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeWithMaxSalary(1));
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeWithMinSalary(1));
    }

    @Test
    public void shouldShowAllEmployeesInDepartment() {
        when(employeeService.showEmployeeList()).thenReturn(EMPLOYEE_LIST);
        assertEquals(EMPLOYEE_LIST_DEPARTMENT_1, departmentService.showAllEmployeesInDepartment(DEPARTMENT_ID_1));
    }

    @Test
    public void shouldShowAllEmployees() {
        when(employeeService.showEmployeeList()).thenReturn(EMPLOYEE_LIST);
        assertEquals(EMPLOYEES_BY_DEPARTMENT, departmentService.showAllEmployees());
    }


}