package com.tsarankou.clientservice.service.exception;

public class DataAlreadyTaken extends ClientException{
    public DataAlreadyTaken() {
        super();
    }

    public DataAlreadyTaken(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DataAlreadyTaken(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAlreadyTaken(String message) {
        super(message);
    }

    public DataAlreadyTaken(Throwable cause) {
        super(cause);
    }
}
