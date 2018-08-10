package com.github.pengliangs.oauth.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author pengliang on 2018-07-17 09:59
 */
@Data
public final class ResultData<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示消息
     */
    private String message;


    /**
     * 返回实际数据
     */
    private T data;


    private ResultData(){}

    private ResultData(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static ResultData createResultData(int code, String message, Object data){
        return new ResultData(code,message,data);
    }

    public static ResultData createResultData(int code, String message){
        return createResultData(code,message,null);
    }
}
