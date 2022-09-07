package com.example.employeemanagementsystem.exception;
import com.example.employeemanagementsystem.dto.ErrorMessageDto;
import com.example.employeemanagementsystem.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestControllerAdvice
public class AppExceptionHandler  {



    @ExceptionHandler(EmsException401.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseDto handleAppExceptionHandler401(EmsException401 emsException401){
        List<ErrorMessageDto> list=new ArrayList<>();
        list.add(new ErrorMessageDto(emsException401.getErrorCode()));
        return new ResponseDto(null,HttpStatus.UNAUTHORIZED.value(),
                list);
    }

    @ExceptionHandler(EmsException404.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseDto handleAppExceptionHandler404(EmsException404 emsException404){
        List<ErrorMessageDto> list=new ArrayList<>();
        list.add(new ErrorMessageDto(emsException404.getErrorCode()));
        return new ResponseDto(null,HttpStatus.NOT_FOUND.value(),
                list);
    }

    @ExceptionHandler(EmsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDto handleAppExceptionHandler(EmsException emsException){
        List<ErrorMessageDto> list=new ArrayList<>();
        list.add(new ErrorMessageDto(emsException.getErrorCode()));
        return new ResponseDto(null,HttpStatus.INTERNAL_SERVER_ERROR.value(),list);
    }
}

