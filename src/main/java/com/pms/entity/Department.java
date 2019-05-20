package com.pms.entity;

import lombok.Data;

@Data
public class Department {
    private int departmentId;
    private String departmentName;
    private int departmentLevel;
    private int departmentStatus;
}
