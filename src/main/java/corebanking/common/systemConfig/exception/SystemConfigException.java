package corebanking.common.systemConfig.exception;

public class SystemConfigException extends RuntimeException {
    public SystemConfigException() {
    }

    public SystemConfigException(String message) {
        super(message);
    }

    public SystemConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemConfigException(Throwable cause) {
        super(cause);
    }

    public SystemConfigException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
