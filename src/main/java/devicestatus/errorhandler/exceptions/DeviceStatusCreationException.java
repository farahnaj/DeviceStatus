package devicestatus.errorhandler.exceptions;

public class DeviceStatusCreationException extends RuntimeException{
    public DeviceStatusCreationException(Exception e) {
        super(e);
    }

    public DeviceStatusCreationException(String message) {
        super(message);
    }
}
