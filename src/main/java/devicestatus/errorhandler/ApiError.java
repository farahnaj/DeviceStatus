package devicestatus.errorhandler;

import java.util.Date;
import org.springframework.http.HttpStatus;

public class ApiError {
    HttpStatus httpStatus;
    String message;
    String stacktrace;
    Date timestamp;

    public ApiError(HttpStatus httpStatus, String message, String stacktrace, Date timestamp) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.stacktrace = stacktrace;
        this.timestamp = timestamp;
   } 
}
