package com.example.employeemanagementsystem.exception;

public class EmsException404 extends Exception{
    ErrorCode errorCode;

    public EmsException404(ErrorCode errorcode){
        super(errorcode.getMessage());
        this.errorCode=errorcode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
