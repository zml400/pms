package com.pms.controller;

import com.pms.VO.ResultPage;
import com.pms.entity.Employee;
import com.pms.VO.Result;
import com.pms.service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("/findEmployeeByGender/{pageNum},{pageSize}")
    public ResultPage findEmployeeByGender(@PathVariable("pageNum")int pageNum,
                                       @PathVariable("pageSize")int pageSize,
                                       String employeeGender){
        ResultPage result = employeeService.findEmployeeByGender(employeeGender,pageNum,pageSize);
        return result;
    }

    @RequestMapping("/findEmployeeByPosition/{pageNum},{pageSize}")
    public ResultPage findEmployeeByPosition(@PathVariable("pageNum")int pageNum,
                                         @PathVariable("pageSize")int pageSize,
                                         String employeePosition){
        ResultPage result = employeeService.findEmployeeByPosition(employeePosition,pageNum,pageSize);
        return result;
    }
    @RequestMapping("/findEmployeeByDepartment/{pageNum},{pageSize}")
    public ResultPage findEmployeeByDepartment(@PathVariable("pageNum")int pageNum,
                                           @PathVariable("pageSize")int pageSize,
                                           String employeeDepartment){
        ResultPage result = employeeService.findEmployeeByDepartment(employeeDepartment,pageNum,pageSize);
        return result;
    }
    @RequestMapping("/findEmployeeByStatus/{pageNum},{pageSize}")
    public ResultPage findEmployeeByStatus(@PathVariable("pageNum")int pageNum,
                                           @PathVariable("pageSize")int pageSize,
                                           int employeeStatus){
        return employeeService.findEmployeeByStatus(employeeStatus,pageNum,pageSize);
    }
    @RequestMapping("/findAllEmployee/{pageNum},{pageSize}")
    public ResultPage findEmployeeByStatus(@PathVariable("pageNum")int pageNum,
                                           @PathVariable("pageSize")int pageSize){
        return employeeService.findAllEmployee(pageNum,pageSize);
    }
}
