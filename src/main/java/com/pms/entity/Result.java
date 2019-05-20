package com.pms.entity;

import lombok.Data;

@Data
public class Result {
    private int code;  //0：成功，1：失败
    private String message;
    private Object data;
}
