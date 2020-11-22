package com.erp.common.response;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Administrator
 */
@Getter
@ToString
public class Result<T> {

    /**
     * 业务是否成功
     */
    private final boolean success;

    /**
     * 业务错误码
     */
    private final Integer code;
    /**
     * 信息描述
     */
    private final String msg;
    /**
     * 返回数据
     */
    private T data;

    private Result(Boolean success, ResultStatus resultStatus, T data) {
        this.success = success;
        this.code = resultStatus.getCode();
        this.msg = resultStatus.getMessage();
        this.data = data;
    }

    private Result(Boolean success, ResultStatus resultStatus, String msg) {
        this.success = success;
        this.code = resultStatus.getCode();
        this.msg = msg;
    }


    public static Result<Void> success() {
        return new Result<Void>(true, ResultStatus.SUCCESS, "操作成功");
    }

    public static Result<Void> success(String msg) {
        return new Result<>(true, ResultStatus.SUCCESS, msg);
    }


    public static <T> Result<T> success(T data) {
        return new Result<T>(true, ResultStatus.SUCCESS, data);
    }


    public static <T> Result<T> failure() {
        return new Result<T>(false, ResultStatus.INTERNAL_SERVER_ERROR, "操作失败");
    }


    public static <T> Result<T> failure(String msg) {
        return new Result<T>(false, ResultStatus.INTERNAL_SERVER_ERROR, msg);
    }

}