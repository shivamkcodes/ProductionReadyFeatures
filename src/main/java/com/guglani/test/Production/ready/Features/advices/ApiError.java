package com.guglani.test.Production.ready.Features.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
@Data
public class ApiError {

    private LocalDateTime timeStamp;
    private String Error;
    private HttpStatus httpStatus;


}
