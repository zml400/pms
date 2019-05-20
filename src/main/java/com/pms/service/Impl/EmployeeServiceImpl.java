package com.pms.service.Impl;

import com.pms.entity.Employee;
import com.pms.entity.Result;
import com.pms.mapper.EmployeeMapper;
import com.pms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public Result addEmployee(Employee employee) {
        Result result = new Result();
        Employee employee1=employeeMapper.findEmployeeByName(employee.getEmployeeName());
        if(employee1!=null){
            result.setCode(1);
            result.setMessage("添加失败，名字已经存在！");
            return result;
        }
        Employee employee2=employeeMapper.findEmployeeByIdentityCard(employee.getEmployeeIdentityCard());
        if(employee2!=null){
            result.setCode(1);
            result.setMessage("添加失败，身份证号已经存在！");
            return result;
        }
        Employee employee3=employeeMapper.findEmployeeByNumber(employee.getEmployeeNumber());
        if(employee3!=null){
            result.setCode(1);
            result.setMessage("添加失败，员工编号已经存在！");
            return result;
        }
        int num=employeeMapper.addEmployee(employee);
        if(num==0){
            result.setCode(1);
            result.setMessage("添加失败！");
        }else
        {
            result.setCode(1);
            result.setMessage("添加成功");
            result.setData(employee);
        }
        return result;
    }

    @Override
    public Result deleteEmployee(int employeeId) {
        Result result = new Result();
        int num=employeeMapper.deleteEmployee(employeeId);
        if(num==0){
            result.setCode(1);
            result.setMessage("删除失败");
        }else {
            result.setCode(0);
            result.setMessage("删除成功");
        }
        return result;
    }

    @Override
    public Result updateEmployee(Employee employee) {
        Result result = new Result();
        int num=employeeMapper.updateEmployee(employee);
        if(num==0){
            result.setCode(1);
            result.setMessage("更新失败");
        }else{
            result.setCode(0);
            result.setMessage("更新成功");
            result.setData(employee);
        }
        return result;
    }

    @Override
    public Result findEmployeeById(int employeeId) {
        Result result = new Result();
        Employee employee = employeeMapper.findEmployeeById(employeeId);
        if(employee==null){
            result.setCode(1);
            result.setMessage("您输入的id不存在，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(employee);
        }
        return result;
    }

    @Override
    public Result findEmployeeByNumber(String employeeNumber) {
        Result result = new Result();
        Employee employee = employeeMapper.findEmployeeByNumber(employeeNumber);
        if(employee==null){
            result.setCode(1);
            result.setMessage("您输入的用户编号不存在，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(employee);
        }
        return result;
    }
    @Override
    public Result findEmployeeByName(String employeeName) {
        Result result = new Result();
        Employee employee = employeeMapper.findEmployeeByName(employeeName);
        if(employee==null){
            result.setCode(1);
            result.setMessage("您输入的用户名不存在，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(employee);
        }
        return result;
    }

    @Override
    public Result findEmployeeByIdentityCard(String employeeIdentityCard) {
        Result result = new Result();
        Employee employee = employeeMapper.findEmployeeByIdentityCard(employeeIdentityCard);
        if(employee==null){
            result.setCode(1);
            result.setMessage("您输入的身份证号不存在，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(employee);
        }
        return result;
    }

    @Override
    public Result findEmployeeByPhone(String employeePhone) {
        Result result = new Result();
        Employee employee = employeeMapper.findEmployeeByPhone(employeePhone);
        if(employee==null){
            result.setCode(1);
            result.setMessage("您输入的电话不存在，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(employee);
        }
        return result;
    }

    @Override
    public Result findEmployeeByGender(String employeeGender) {
        Result result = new Result();
        List<Employee> employeeList = employeeMapper.findEmployeeByGender(employeeGender);
        if(employeeList.size()==0){
            result.setCode(1);
            result.setMessage("您输入的性别不存在或者没有记录，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(employeeList);
        }
        return result;
    }

    @Override
    public Result findEmployeeByPosition(String employeePosition) {
        Result result = new Result();
        List<Employee> employeeList = employeeMapper.findEmployeeByPosition(employeePosition);
        if(employeeList.size()==0){
            result.setCode(1);
            result.setMessage("您输入的职位不存在，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(employeeList);
        }
        return result;
    }

    @Override
    public Result findEmployeeByDepartment(String employeeDepartment) {
        Result result = new Result();
        List<Employee> employeeList = employeeMapper.findEmployeeByDepartment(employeeDepartment);
        if(employeeList.size()==0){
            result.setCode(1);
            result.setMessage("您输入的部门不存在，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(employeeList);
        }
        return result;
    }
    @Override
    public Result findEmployeeByStatus(int employeeStatus){
        Result result = new Result();
        List<Employee> employeeList = employeeMapper.findEmployeeByStatus(employeeStatus);
        if(employeeList.size()==0){
            result.setCode(1);
            result.setMessage("你输入的状态不存在记录，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(employeeList);
        }
        return result;
    }
    @Override
    public Result findAllEmployee() {
        Result result = new Result();
        List<Employee> employeeList = employeeMapper.findAllEmployee();
        result.setCode(0);
        result.setMessage("查找成功");
        result.setData(employeeList);
        return result;
    }
}
