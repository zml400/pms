package com.pms.service.Impl;

import com.pms.entity.Department;
import com.pms.entity.Result;
import com.pms.mapper.DepartmentMapper;
import com.pms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Result addDepartment(Department department) {
        Department department1=departmentMapper.findDepartmentByName(department.getDepartmentName());
        if(department1!=null){
            return Result.failed("添加失败，名字已经存在！");
        }else{
            int num=departmentMapper.addDepartment(department);
            if(num==0){
                return Result.failed("添加失败！");
            }else
            {
                return Result.success("添加成功",department);
            }
        }
    }

    @Override
    public Result deleteDepartment(int departmentId) {
        int num=departmentMapper.deleteDepartment(departmentId);
        if(num==0){
            return Result.failed("删除失败");

        }else {
            return Result.success("删除成功");
        }
    }

    @Override
    public Result updateDepartment(Department department) {
        int num=departmentMapper.updateDepartment(department);
        if(num==0){
            return Result.failed("更新失败");
        }else{
            return Result.success("更新成功",department);
        }
    }

    @Override
    public Result findDepartmentById(int departmentId) {
        Department department = departmentMapper.findDepartmentById(departmentId);
        if(department==null){
            return Result.failed("您输入的用户id错误，请重新输入");
        }else {
            return Result.success("查找成功",department);
        }
    }

    @Override
    public Result findDepartmentByName(String departmentName) {
        Department department = departmentMapper.findDepartmentByName(departmentName);
        if(department==null){
            return Result.failed("您输入的用户名错误，请重新输入");
        }else {
            return Result.success("查找成功",department);
        }
    }

    @Override
    public Result findDepartmentByStatus(int DepartmentStatus){
        List<Department> departmentList = departmentMapper.findDepartmentByStatus(DepartmentStatus);
        if(departmentList.size()==0) {
            return Result.success("查找成功", departmentList);
        }else {
            return Result.success("查找成功",departmentList);
        }
    }
    @Override
    public Result findAllDepartment() {
        List<Department> departmentList = departmentMapper.findAllDepartment();
        if(departmentList.size()==0){
            return Result.success("没有记录");
        }else{
            return Result.success("查找成功",departmentList);
        }
    }
}
