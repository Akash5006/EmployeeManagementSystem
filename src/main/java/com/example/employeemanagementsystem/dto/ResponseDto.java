package com.example.employeemanagementsystem.dto;

import java.util.Date;
import java.util.List;

public class ResponseDto {
    private Date timeStamp;
    private Integer httpStatus;
    private Object data;
    //private ErrorMessageDto error;
    private List<ErrorMessageDto> error;

    public ResponseDto() {
    }

    public ResponseDto(Object data, Integer httpStatus) {
        this.data = data;
        this.httpStatus = httpStatus;
        this.timeStamp = new Date();
    }

    public ResponseDto(Object data, Integer httpStatus, List<ErrorMessageDto> error) {
        this.data = data;
        this.httpStatus = httpStatus;
        this.timeStamp = new Date();
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public List<ErrorMessageDto> getError() {
        return error;
    }
}
