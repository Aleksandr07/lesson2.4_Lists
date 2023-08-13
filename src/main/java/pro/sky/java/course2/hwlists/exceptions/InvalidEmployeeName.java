package pro.sky.java.course2.hwlists.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmployeeName extends RuntimeException{

    public InvalidEmployeeName(String message) {
        super(message);
    }
}
