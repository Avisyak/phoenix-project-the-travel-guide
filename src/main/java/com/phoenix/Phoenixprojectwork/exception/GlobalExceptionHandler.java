package com.phoenix.Phoenixprojectwork.exception;

import com.phoenix.Phoenixprojectwork.config.CustomMessageSource;
import com.phoenix.Phoenixprojectwork.constants.MessageConstants;
import com.phoenix.Phoenixprojectwork.dto.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final CustomMessageSource customMessageSource;


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<GlobalApiResponse> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        String message = "Data integrity violation occured:" + e.getMessage();
        GlobalApiResponse response = GlobalApiResponse.builder()
                .status(false)
                .message(message)
                .data(customMessageSource.get(MessageConstants.UNIQUE_CONSTRAINT_ERROR, "Name"))
                .build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<GlobalApiResponse> handleAppException(AppException e) {
        String message = e.getMessage();
        GlobalApiResponse response = GlobalApiResponse.builder()
                .status(false)
                .message(message)
                .data(customMessageSource.get(MessageConstants.ERROR, "Id"))
                .build();
        return ResponseEntity.badRequest().body(response);
    }
}
