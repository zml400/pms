package com.pms.VO;

import lombok.Data;

@Data
public class ResultPage {
    private int code;  //0：成功，1：失败
    private String message;
    //有多少页
    private long pagesTotal;
    private Object data;
    private ResultPage(){}
    public static ResultPage build(int code, String message,
                                   long  pagesTotal, Object data){
        ResultPage result = new ResultPage();
        result.setCode(code);
        result.setPagesTotal(pagesTotal);
        result.setMessage(message);
        result.setData(data);
        return  result;
    }
    public static ResultPage failed(String message){

        return build(1,message,0,"");
    }
    public static ResultPage success(String message, long  pagesTotal, Object data){
        return build(0,message,pagesTotal,data);
    }
}
