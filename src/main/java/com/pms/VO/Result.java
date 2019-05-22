package com.pms.VO;

import lombok.Data;

@Data
public class Result {
    private int code;  //0：成功，1：失败
    private String message;
    private Object data;
    private Result(){}
    public static Result build(int code,String message,Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return  result;
    }
    public static Result success(){
        return build(0,"请求成功！","");
    }
    public static Result success(String message){
        return build(0,message,"");
    }
    public static Result success(String message,Object data){
        return build(0,message,data);
    }
    public static Result failed(){
        return build(1,"请求失败！","");
    }
    public static Result failed(String message){
        return build(1,message,"");
    }
    public static Result failed(String message,Object object){
        return build(1,message,object);
    }
}
