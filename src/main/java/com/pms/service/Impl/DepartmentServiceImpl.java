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
        Result result = new Result();
        Department department1=departmentMapper.findDepartmentByName(department.getDepartmentName());
        if(department1!=null){
            result.setCode(1);
            result.setMessage("添加失败，名字已经存在！");
        }else{
            int num=departmentMapper.addDepartment(department);
            if(num==0){
                result.setCode(1);
                result.setMessage("添加失败！");
            }else
            {
                result.setCode(1);
                result.setMessage("添加成功");
                result.setData(department);
            }
        }
        return result;
    }

    @Override
    public Result deleteDepartment(int departmentId) {
        Result result = new Result();
        int num=departmentMapper.deleteDepartment(departmentId);
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
    public Result updateDepartment(Department department) {
        Result result = new Result();
        int num=departmentMapper.updateDepartment(department);
        if(num==0){
            result.setCode(1);
            result.setMessage("更新失败");
        }else{
            result.setCode(0);
            result.setMessage("更新成功");
            result.setData(department);
        }
        return result;
    }

    @Override
    public Result findDepartmentById(int departmentId) {
        Result result = new Result();
        Department department = departmentMapper.findDepartmentById(departmentId);
        if(department==null){
            result.setCode(1);
            result.setMessage("您输入的用户名错误，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(department);
        }
        return result;
    }

    @Override
    public Result findDepartmentByName(String departmentName) {
        Result result = new Result();
        Department department = departmentMapper.findDepartmentByName(departmentName);
        if(department==null){
            result.setCode(1);
            result.setMessage("您输入的用户名错误，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(department);
        }
        return result;
    }

    @Override
    public Result findDepartmentByStatus(int DepartmentStatus){
        Result result = new Result();
        List<Department> departmentList = departmentMapper.findDepartmentByStatus(DepartmentStatus);
        if(departmentList.size()==0){
            result.setCode(1);
            result.setMessage("您输入的状态没有记录，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(departmentList);
        }
        return result;
    }
    @Override
    public Result findAllDepartment() {
        Result result = new Result();
        List<Department> departmentList = departmentMapper.findAllDepartment();
        result.setCode(0);
        result.setMessage("查找成功");
        result.setData(departmentList);
        return result;
    }
}
