package com.pms.entity;

import lombok.Data;

@Data
public class Employee {
    private int employeeId;
    private String employeeNumber;
    private String employeeName;
    private String employeeIdentityCard;
    private String employeeGender;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    private String employeePosition;
    private String employeeDepartment;
    private int employeeStatus;

}
