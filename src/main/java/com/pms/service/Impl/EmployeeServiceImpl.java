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

    /**
     * 添加员工信息
     * @param employee
     * @return
     */
    @Override
    public Result addEmployee(Employee employee) {
        Employee employee1=employeeMapper.findEmployeeByName(employee.getEmployeeName());
        if(employee1!=null){
            return Result.failed("添加失败，名字已经存在！");
        }
        Employee employee2=employeeMapper.findEmployeeByIdentityCard(employee.getEmployeeIdentityCard());
        if(employee2!=null){
            return Result.failed("添加失败，身份证号已经存在！");
        }
        Employee employee3=employeeMapper.findEmployeeByNumber(employee.getEmployeeNumber());
        if(employee3!=null){
            return Result.failed("添加失败，员工编号已经存在！");
        }
        int num=employeeMapper.addEmployee(employee);
        if(num==0){
            return  Result.failed("添加失败！");
        }else
        {
            return Result.success("添加成功",employee);
        }
    }

    @Override
    public Result deleteEmployee(int employeeId) {
        int num=employeeMapper.deleteEmployee(employeeId);
        if(num==0){
            return Result.failed("删除失败");
        }else {
            return Result.failed("删除成功");
        }
    }

    @Override
    public Result updateEmployee(Employee employee) {
        int num=employeeMapper.updateEmployee(employee);
        if(num==0){
            return Result.failed("更新失败");
        }else{
            return Result.success("更新成功",employee);
        }
    }

    @Override
    public Result findEmployeeById(int employeeId) {
        Employee employee = employeeMapper.findEmployeeById(employeeId);
        if(employee==null){
            return Result.failed("您输入的id不存在，请重新输入");
        }else {
            return Result.success("查找成功",employee);
        }
    }

    @Override
    public Result findEmployeeByNumber(String employeeNumber) {
        Employee employee = employeeMapper.findEmployeeByNumber(employeeNumber);
        if(employee==null){
            return Result.failed("您输入的用户编号不存在，请重新输入");
        }else {
            return Result.success("查找成功",employee);
        }
    }
    @Override
    public Result findEmployeeByName(String employeeName) {
        Employee employee = employeeMapper.findEmployeeByName(employeeName);
        if(employee==null){
            return Result.failed("您输入的用户名不存在，请重新输入");
        }else {
            return Result.success("查找成功",employee);
        }
    }

    @Override
    public Result findEmployeeByIdentityCard(String employeeIdentityCard) {
        Employee employee = employeeMapper.findEmployeeByIdentityCard(employeeIdentityCard);
        if(employee==null){
            return Result.failed("您输入的身份证号不存在，请重新输入");
        }else {
            return Result.success("查找成功",employee);
        }
    }

    @Override
    public Result findEmployeeByPhone(String employeePhone) {
        Employee employee = employeeMapper.findEmployeeByPhone(employeePhone);
        if(employee==null){
            return Result.failed("您输入的电话不存在，请重新输入");
        }else {
            return Result.success("查找成功",employee);
        }
    }

    @Override
    public Result findEmployeeByGender(String employeeGender) {
        List<Employee> employeeList = employeeMapper.findEmployeeByGender(employeeGender);
        if(employeeList.size()==0){
            return Result.failed("您输入的性别不存在或者没有记录，请重新输入");
        }else {
            return Result.success("查找成功",employeeList);
        }
    }

    @Override
    public Result findEmployeeByPosition(String employeePosition) {
        List<Employee> employeeList = employeeMapper.findEmployeeByPosition(employeePosition);
        if(employeeList.size()==0){
            return Result.failed("您输入的职位不存在，请重新输入");
        }else {
            return Result.success("查找成功",employeeList);
        }
    }

    @Override
    public Result findEmployeeByDepartment(String employeeDepartment) {
        List<Employee> employeeList = employeeMapper.findEmployeeByDepartment(employeeDepartment);
        if(employeeList.size()==0){
            return Result.failed("您输入的部门不存在，请重新输入");
        }else {
            return Result.success("查找成功",employeeList);
        }
    }
    @Override
    public Result findEmployeeByStatus(int employeeStatus){
        List<Employee> employeeList = employeeMapper.findEmployeeByStatus(employeeStatus);
        if(employeeList.size()==0){
            return Result.failed("您输入的状态不存在，请重新输入");
        }else {
            return Result.success("查找成功",employeeList);
        }
    }
    @Override
    public Result findAllEmployee() {
        List<Employee> employeeList = employeeMapper.findAllEmployee();
        if(employeeList.size()==0){
            return Result.failed("没有记录");
        }else {
            return Result.success("查找成功",employeeList);
        }
    }
}
