package pro.sky.java.course2.hwlists.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.hwlists.exceptions.InvalidEmployeeName;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeValidationServiceImpl implements EmployeeValidationService{
    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);
    }

    private void validateName(String name) {
        if (!isAlpha(name)) {
            throw new InvalidEmployeeName("Некорректное имя/фамилия");
        }
    }
}
