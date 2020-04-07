package com.citicbank.monitor.core.result;

import com.github.pagehelper.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 响应结果生成工具
 */
public class ResultBuilder {

    public static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
//    public static final String PAGINATION_KEY = "pagination";

    /**
     * 无数据的成功结果
     *
     * @return
     */
    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    /**
     * 有数据的成功结果
     *
     * @param data
     * @return
     */
    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }


    /**
     * *特殊失败处理结果
     * 此值只用于判断审核事件返回结果
     *
     * @param message
     * @return
     */
    public static Result genSpecialFailResult(String message) {
        return new Result()
                .setCode(ResultCode.SPECIAL_ERROR)
                .setMessage(message);
    }

    /**
     * 失败结果
     *
     * @param message
     * @return
     */
    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    /**
     * 登陆失败结果
     *
     * @param message
     * @return
     */
    public static Result genLoginFailResult(String message) {
        return new Result()
                .setCode(ResultCode.LOGIN_FAIL)
                .setMessage(message);
    }

    /**
     * 未认证结果
     *
     * @param message
     * @return
     */
    public static Result genUnauthorizedResult(String message) {
        return new Result()
                .setCode(ResultCode.UNAUTHORIZED)
                .setMessage(message);
    }

    /**
     * 未授权结果
     *
     * @param message
     * @return
     */
    public static Result genForbiddenResult(String message) {
        return new Result()
                .setCode(ResultCode.FORBIDDEN)
                .setMessage(message);
    }

    /**
     * 服务器内部错误结果
     *
     * @param message
     * @return
     */
    public static Result genServerErrorResult(String message) {
        return new Result()
                .setCode(ResultCode.INTERNAL_SERVER_ERROR)
                .setMessage(message);
    }

    /**
     * 请求资源不存在结果
     *
     * @param message
     * @return
     */
    public static Result genNotFoundResult(String message) {
        return new Result()
                .setCode(ResultCode.NOT_FOUND)
                .setMessage(message);
    }

    /**
     * 请求资源不存在结果
     *
     * @return
     */
    public static Result genNotFoundResult() {
        return new Result().setCode(ResultCode.NOT_FOUND);
    }

}
