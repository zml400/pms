package com.pms.service;

import com.pms.VO.ResultPage;
import com.pms.entity.Employee;
import com.pms.VO.Result;

public interface EmployeeService {
    public Result addEmployee(Employee employee);
    public Result deleteEmployee(int employeeId);
    public Result updateEmployee(Employee employee);
    public Result findEmployeeById(int employeeId);
    public Result findEmployeeByNumber(String employeeNumber);
    public Result findEmployeeByName(String employeeName);
    public Result findEmployeeByIdentityCard(String employeeIdentityCard);
    public Result findEmployeeByPhone(String employeePhone);
    public ResultPage findEmployeeByGender(String employeeGender,int pageNum, int pageSize);
    public ResultPage findEmployeeByPosition(String employeePosition,int pageNum, int pageSize);
    public ResultPage findEmployeeByDepartment(String employeeDepartment,int pageNum, int pageSize);
    public ResultPage findEmployeeByStatus(int employeeStatus,int pageNum, int pageSize);
    public ResultPage findAllEmployee(int pageNum, int pageSize);
}
