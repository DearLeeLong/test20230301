package com.ruoyi.intelligent_explanation.controller.result;

import lombok.Data;

import java.util.HashMap;

@Data
public class Result<T> {
    private  int code;
    private String message;
    private T data;
    public Result(){

    }
    public static<T>  Result init(T data){
        Result<T> result = new Result<T>();
        if(data!=null){
            result.setData(data);
        }
        return result;
    }

    public static<T>  Result init(){
        Result<T> result = new Result<T>();

        return result;
    }
    public static<T> Result init(T data,int code,String message){
        Result result = init(data);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static<T> Result<T> success(){
        Result result = success(null);
        return result;
    }

    public static<T> Result<T> success(T data){
        Result result = init(data, 200, "成功");
        return result;
    }

    public static<T> Result<T> fail(){
        Result result = fail(null);
        return result;
    }

    public static<T> Result<T> fail(T data){
        Result result = init(data, 0, "失败");
        return result;
    }


}
