package io.playground.junittest.common;

public class NoStackTraceException extends RuntimeException {

    public NoStackTraceException(String message) {
        super(message);
    }

    public NoStackTraceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoStackTraceException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
