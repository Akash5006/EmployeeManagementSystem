package com.example.employeemanagementsystem.exception;

public class EmsException extends Exception{
    ErrorCode errorCode;

public EmsException(ErrorCode errorcode){
    super(errorcode.getMessage());
    this.errorCode=errorcode;
}

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
