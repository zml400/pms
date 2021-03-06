package com.pms.service;

import com.pms.VO.ResultPage;
import com.pms.entity.Department;
import com.pms.VO.Result;

public interface DepartmentService {
    public Result addDepartment(Department department);
    public Result deleteDepartment(int departmentId);
    public Result updateDepartment(Department departmentId);
    public Result findDepartmentById(int departmentId);
    public Result findDepartmentByName(String departmentName);
    public ResultPage findDepartmentByStatus(int DepartmentStatus,int pageNum,int pageSize);
    public ResultPage findAllDepartment(int pageNum, int pageSize);
}
