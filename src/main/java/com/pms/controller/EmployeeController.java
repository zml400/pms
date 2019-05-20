package com.pms.controller;

import com.pms.entity.Employee;
import com.pms.entity.Result;
import com.pms.service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    //添加员工
    @RequestMapping("/addEmployee")
    public Result addEmployee(Employee employee){
        Result result = employeeService.addEmployee(employee);
        return result;

    }
    @RequestMapping("/deleteEmployee")
    public Result deleteEmployee(int employeeId){
        Result result = employeeService.deleteEmployee(employeeId);
        return result;
    }
    @RequestMapping("/updateEmployee")
    public Result updateEmployee(Employee employee){
        Result result = employeeService.updateEmployee(employee);
        return result;
    }
    @RequestMapping("/findEmployeeByName")
    public Result findEmployeeByName(String employeeName){
        Result result = employeeService.findEmployeeByName(employeeName);
        return result;
    }

    @RequestMapping("/findEmployeeByNumber")
    public Result findEmployeeByNumber(String employeeNumber){
        Result result = employeeService.findEmployeeByNumber(employeeNumber);
        return result;
    }
    @RequestMapping("/findEmployeeByIdentityCard")
    public Result findEmployeeByIdentityCard(String employeeIdentityCard){
        Result result = employeeService.findEmployeeByIdentityCard(employeeIdentityCard);
        return result;
    }
    @RequestMapping("/findEmployeeByPhone")
    public Result findEmployeeByPhone(String employeePhone){
        Result result = employeeService.findEmployeeByPhone(employeePhone);
        return result;
    }
    @RequestMapping("/findEmployeeByGender")
    public Result findEmployeeByGender(String employeeGender){
        Result result = employeeService.findEmployeeByGender(employeeGender);
        return result;
    }

    @RequestMapping("/findEmployeeByPosition")
    public Result findEmployeeByPosition(String employeePosition){
        Result result = employeeService.findEmployeeByPosition(employeePosition);
        return result;
    }
    @RequestMapping("/findEmployeeByDepartment")
    public Result findEmployeeByDepartment(String employeeDepartment){
        Result result = employeeService.findEmployeeByDepartment(employeeDepartment);
        return result;
    }
    @RequestMapping("/findEmployeeByStatus")
    public Result findEmployeeByStatus(int employeeStatus){
        Result result = employeeService.findEmployeeByStatus(employeeStatus);
        return result;
    }
    @RequestMapping("/findAllEmployee")
    public Result findAllEmployee(){
        Result result = employeeService.findAllEmployee();
        return result;
    }



}
