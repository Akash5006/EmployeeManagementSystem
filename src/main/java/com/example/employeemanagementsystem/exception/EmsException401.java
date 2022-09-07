package com.example.employeemanagementsystem.exception;

public class EmsException401 extends Exception{
    ErrorCode errorCode;

    public EmsException401(ErrorCode errorcode){
        super(errorcode.getMessage());
        this.errorCode=errorcode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
