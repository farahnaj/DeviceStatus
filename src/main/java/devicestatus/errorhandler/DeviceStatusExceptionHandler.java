package devicestatus.errorhandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.Instant;
import java.util.Date;

import devicestatus.errorhandler.exceptions.DeviceStatusCreationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class DeviceStatusExceptionHandler {
  // Exception handler for DeviceStatusCreationException
  @ExceptionHandler(DeviceStatusCreationException.class)
  public ResponseEntity<ApiError> handleException(Exception e) {
    HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    StringWriter writer = new StringWriter();
    PrintWriter printWriter = new PrintWriter(writer);
    e.printStackTrace(printWriter);
    String stacktrace = writer.toString();
    return new ResponseEntity<ApiError>(
        new ApiError(httpStatus, e.getMessage(), stacktrace, Date.from(Instant.now())),
        httpStatus);
  }

}
