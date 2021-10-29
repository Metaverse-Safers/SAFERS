package com.safers.common.handler;

import com.safers.api.response.ErrorResponse;
import com.safers.common.util.ErrorCode;
import com.sun.rmi.rmid.ExecPermission;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExpectionHadler {

    /* HTTP 401 Exception */
    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> methodAuthenticationHandler(final AuthorizationServiceException e){
        return ResponseEntity.status(ErrorCode.UNAUTHORIZED.getStatus()).body(new ErrorResponse(ErrorCode.UNAUTHORIZED));
    }

    /* HTTP 404 Exception */
    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> methodNotSupportedHandler(final NoHandlerFoundException e){
        return ResponseEntity.status(ErrorCode.NOT_FOUND.getStatus()).body(new ErrorResponse(ErrorCode.NOT_FOUND));
    }

    /* HTTP 500 Exception */
    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> exceptionHandler (final Exception e){
        return ResponseEntity.status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus()).body(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR));
    }

}
