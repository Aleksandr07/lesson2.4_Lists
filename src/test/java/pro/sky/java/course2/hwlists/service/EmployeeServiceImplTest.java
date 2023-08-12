package pro.sky.java.course2.hwlists.service;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.hwlists.domain.Employee;
import pro.sky.java.course2.hwlists.exceptions.EmployeeAlreadyAddedException;
import pro.sky.java.course2.hwlists.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.hwlists.exceptions.InvalidEmployeeName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.hwlists.constants.TestConstants.*;

class EmployeeServiceImplTest {
    private final EmployeeValidationService employeeValidationService = new EmployeeValidationServiceImpl();
    private final EmployeeService out = new EmployeeServiceImpl(employeeValidationService);


    @Test
    public void shouldAddEmployee() {
        assertFalse(out.showEmployeeList().contains(FIRST_EMPLOYEE));
        Employee actual = out.addEmployee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_ID_1, SALARY_1);
        assertTrue(out.showEmployeeList().contains(actual));
        assertEquals(actual, FIRST_EMPLOYEE);

    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedException() {
        out.addEmployee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_ID_1, SALARY_1);
        assertThrows(EmployeeAlreadyAddedException.class, () -> out.addEmployee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_ID_1, SALARY_1));
    }

    @Test
    public void shouldThrowInvalidEmployeeNameException() {
        assertThrows(InvalidEmployeeName.class, () -> out.addEmployee(INVALID_FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_ID_1, SALARY_1));
    }

    @Test
    public void shouldRemoveEmployee() {
        assertFalse(out.showEmployeeList().contains(FIRST_EMPLOYEE));
        Employee addedEmployee = out.addEmployee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_ID_1, SALARY_1);
        assertTrue(out.showEmployeeList().contains(addedEmployee));
        assertEquals(1, out.showEmployeeList().size());
        Employee actual = out.removeEmployee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_ID_1, SALARY_1);
        assertEquals(actual, FIRST_EMPLOYEE);
        assertFalse(out.showEmployeeList().contains(FIRST_EMPLOYEE));
        assertEquals(0, out.showEmployeeList().size());
    }

    @Test
    public void shouldFindEmployee() {
        assertFalse(out.showEmployeeList().contains(FIRST_EMPLOYEE));
        Employee addedEmployee = out.addEmployee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_ID_1, SALARY_1);
        assertTrue(out.showEmployeeList().contains(addedEmployee));
        Employee actual = out.findEmployee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_ID_1, SALARY_1);
        assertEquals(actual, FIRST_EMPLOYEE);
    }

    @Test
    public void shouldThrowEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_ID_1, SALARY_1));
        assertThrows(EmployeeNotFoundException.class, () -> out.removeEmployee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_ID_1, SALARY_1));
    }

    @Test
    public void shouldShowEmployeeList() {
        Employee first_employee = out.addEmployee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_ID_1, SALARY_1);
        Employee second_employee = out.addEmployee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_ID_2, SALARY_2);

        assertIterableEquals(List.of(first_employee, second_employee), out.showEmployeeList());
    }
}