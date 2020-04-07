package com.citicbank.monitor.exception;

/**
 * 服务异常
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 4409289248969742539L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
