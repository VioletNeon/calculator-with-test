package violet.neon.calculatorwithtest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoneZeroDivideException extends IllegalArgumentException {
    public NoneZeroDivideException() {
    }

    public NoneZeroDivideException(String s) {
        super(s);
    }

    public NoneZeroDivideException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoneZeroDivideException(Throwable cause) {
        super(cause);
    }
}
