package com.erp.common.exception;

/**
 * @author Administrator
 * 自定义结果异常
 */
public class ResultException extends RuntimeException {

    //private ResultStatus resultStatus

    public ResultException(String message) {
        super(message);
    }
}
