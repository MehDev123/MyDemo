package com.spring.security.demospringsecurity.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Created by Mehran on 7/19/2023
 */
@Getter
public class ApplicationException extends RuntimeException{
    private String message;
    private String errorCode = HttpStatus.INTERNAL_SERVER_ERROR.toString();

    public ApplicationException(String exceptionKey) {
        this.message = exceptionKey;
    }

    public ApplicationException(List<String> exceptionsKey) {
        for (String expMsg : exceptionsKey) {
            message += expMsg + "<br/>";
        }
    }

    public ApplicationException(String exceptionKey, String errorCode) {
        this.message = exceptionKey;
        this.errorCode = errorCode;
    }

    public ApplicationException(List<String> exceptionsKey, String errorCode) {
        for (String expMsg : exceptionsKey) {
            message += expMsg + "<br/>";
        }
        this.errorCode = errorCode;
    }


}
