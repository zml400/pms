package com.pms.service;

import com.pms.entity.Employee;
import com.pms.entity.Result;

public interface EmployeeService {
    public Result addEmployee(Employee employee);
    public Result deleteEmployee(int employeeId);
    public Result updateEmployee(Employee employee);
    public Result findEmployeeById(int employeeId);
    public Result findEmployeeByNumber(String employeeNumber);
    public Result findEmployeeByName(String employeeName);
    public Result findEmployeeByIdentityCard(String employeeIdentityCard);
    public Result findEmployeeByPhone(String employeePhone);
    public Result findEmployeeByGender(String employeeGender);
    public Result findEmployeeByPosition(String employeePosition);
    public Result findEmployeeByDepartment(String employeeDepartment);
    public Result findEmployeeByStatus(int employeeStatus);
    public Result findAllEmployee();
}
