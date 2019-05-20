package com.pms.service;

import com.pms.entity.Department;
import com.pms.entity.Result;

public interface DepartmentService {
    public Result addDepartment(Department department);
    public Result deleteDepartment(int departmentId);
    public Result updateDepartment(Department departmentId);
    public Result findDepartmentById(int departmentId);
    public Result findDepartmentByName(String departmentName);
    public Result findDepartmentByStatus(int DepartmentStatus);
    public Result findAllDepartment();
}
