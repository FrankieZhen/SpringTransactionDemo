
package com.example.demo.util;


import java.io.Serializable;

public class BizResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String message;
    private T data;

    public BizResponse() {
        this(BizErrorCodeEnum.SUCCESS, BizErrorCodeEnum.SUCCESS.getDesc());
    }

    public BizResponse(BizEnum errorCode) {
        this(errorCode, errorCode.getDesc());
    }

    public BizResponse(T data) {
        this(BizErrorCodeEnum.SUCCESS, BizErrorCodeEnum.SUCCESS.getDesc(), data);
    }

    public BizResponse(BizEnum errorCode, String message) {
        this(errorCode, message, (T) null);
    }

    public BizResponse(BizEnum errorCode, String message, T data) {
        this.code = errorCode.getCode();
        this.message = message;
        this.data = data;
    }

    public static <T> BizResponse<T> success() {
        return new BizResponse();
    }

    public static <T> BizResponse<T> success(String message) {
        return new BizResponse(BizErrorCodeEnum.SUCCESS, message);
    }

    public static <T> BizResponse<T> success(T data) {
        return new BizResponse(data);
    }

    public static <T> BizResponse<T> success(String message, T data) {
        return new BizResponse(BizErrorCodeEnum.SUCCESS, message, data);
    }

    public static <T> BizResponse<T> operationFailed() {
        return new BizResponse(BizErrorCodeEnum.OPERATION_FAILED);
    }

    public static <T> BizResponse<T> operationFailed(String message) {
        return new BizResponse(BizErrorCodeEnum.OPERATION_FAILED, message);
    }

    public static <T> BizResponse<T> operationFailed(T data) {
        return new BizResponse(BizErrorCodeEnum.OPERATION_FAILED, BizErrorCodeEnum.OPERATION_FAILED.getDesc(), data);
    }

    public static <T> BizResponse<T> operationFailed(String message, T data) {
        return new BizResponse(BizErrorCodeEnum.OPERATION_FAILED, message, data);
    }

    public static <T> BizResponse<T> systemError() {
        return new BizResponse(BizErrorCodeEnum.SYSTEM_ERROR);
    }

    public static <T> BizResponse<T> systemError(String message) {
        return new BizResponse(BizErrorCodeEnum.SYSTEM_ERROR, message);
    }

    public static <T> BizResponse<T> systemError(T data) {
        return new BizResponse(BizErrorCodeEnum.SYSTEM_ERROR, BizErrorCodeEnum.SYSTEM_ERROR.getDesc(), data);
    }

    public static <T> BizResponse<T> systemError(String message, T data) {
        return new BizResponse(BizErrorCodeEnum.SYSTEM_ERROR, message, data);
    }

    public static <T> BizResponse<T> paramError() {
        return new BizResponse(BizErrorCodeEnum.PARAM_ERROR);
    }

    public static <T> BizResponse<T> paramError(String message) {
        return new BizResponse(BizErrorCodeEnum.PARAM_ERROR, message);
    }

    public static <T> BizResponse<T> paramError(T data) {
        return new BizResponse(BizErrorCodeEnum.PARAM_ERROR, BizErrorCodeEnum.PARAM_ERROR.getDesc(), data);
    }

    public static <T> BizResponse<T> paramError(String message, T data) {
        return new BizResponse(BizErrorCodeEnum.PARAM_ERROR, message, data);
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setData(final T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BizResponse(code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
    }
}
