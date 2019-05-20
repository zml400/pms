package com.pms.entity;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private String userPhone;
    private String userEmail;
    private int userStatus;
    private int userLevel;
    private String userDescription;
}
