package com.guglani.test.Production.ready.Features.advices;

import com.guglani.test.Production.ready.Features.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(ResourceNotFoundException.class )
    public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException e){
        ApiError apiError=ApiError.builder().
                timeStamp(LocalDateTime.now())
                .Error(e.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }

    }

