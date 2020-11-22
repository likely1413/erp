package com.erp.common.exception;

import com.erp.common.response.Result;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Administrator
 * 统一全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {


    @ExceptionHandler(ResultException.class)
    public Result resultExceptionHandler(ResultException e) {
        return Result.failure(e.getMessage());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return Result.failure(objectError.getDefaultMessage());
    }


    @ExceptionHandler(NullPointerException.class)
    public Result nullPointerExceptionHandler(NullPointerException e) {
        return Result.failure("空指针异常");
    }


}
