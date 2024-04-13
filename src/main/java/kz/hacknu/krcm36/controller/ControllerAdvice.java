package kz.hacknu.krcm36.controller;

import jakarta.servlet.http.HttpServletRequest;
import kz.hacknu.krcm36.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorDto> handle(HttpServletRequest httpServletRequest, RuntimeException e) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(
                ErrorDto.builder()
                        .timestamp(LocalDateTime.now())
                        .status(INTERNAL_SERVER_ERROR.value())
                        .error(INTERNAL_SERVER_ERROR.getReasonPhrase())
                        .path(httpServletRequest.getServletPath())
                        .message(e.getMessage())
                        .build());
    }
}
