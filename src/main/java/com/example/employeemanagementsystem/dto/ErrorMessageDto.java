package com.example.employeemanagementsystem.dto;

import com.example.employeemanagementsystem.exception.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class ErrorMessageDto {
    private String code;
    private String message;

    public ErrorMessageDto() {
    }

    public ErrorMessageDto(ErrorCode errorCode) {
        this.code = errorCode.name();
        this.message = errorCode.getMessage();
    }

    public ErrorMessageDto(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
