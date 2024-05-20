package com.tsarankou.clientservice.web.errorhandler;

import com.tsarankou.clientservice.dto.ErrorDto;
import com.tsarankou.clientservice.service.exception.ClientException;
import com.tsarankou.clientservice.service.exception.DataAlreadyTaken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Controller
@RestControllerAdvice("org.springframework.web")
public class RestErrorHandler {

    private static final String SERVER_ERROR = "Server Error";
    private static final String CLIENT_ERROR = "Client Error";
    private static final String SERVER_ERROR_DEFAULT_MESSAGE = "Sorry, We are working on...";
    private static final String DATA_ALREADY_TAKEN = "Data already taken";

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto error(ClientException e) {
        return new ErrorDto(CLIENT_ERROR, e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto error(DataAlreadyTaken e) {
        return new ErrorDto(SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorDto error(Exception e) {
        return new ErrorDto(DATA_ALREADY_TAKEN, SERVER_ERROR_DEFAULT_MESSAGE);
    }

}
