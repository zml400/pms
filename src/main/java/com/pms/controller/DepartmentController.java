package com.pms.controller;

import com.pms.VO.ResultPage;
import com.pms.entity.Department;
import com.pms.VO.Result;
import com.pms.service.Impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Department")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;


    /**
     * 添加部门信息
     * @param department
     * @return result
     */
    @RequestMapping("/addDepartment")
    public Result addDepartment(Department department){
        Result result = departmentService.addDepartment(department);
        return result;

    }
    /**
     * 删除部门
     * @param departmentId
     * @return result
     */
    @RequestMapping("/deleteDepartment")
    public Result deleteDepartment(int departmentId){
        Result result =departmentService.deleteDepartment(departmentId);
        return result;
    }

    /**
     * 更新部门
     * @param department
     * @return result
     */
    @RequestMapping("/updateDepartment")
    public Result updateDepartment(Department department){
        Result result = departmentService.updateDepartment(department);
        return result;
    }

    /**
     * 通过姓名查找部门
     * @param departmentName
     * @return result
     */
    @RequestMapping("/findDepartmentByName")
    public Result findDepartmentByName(String departmentName){
        return departmentService.findDepartmentByName(departmentName);
    }
    /**
     * 通过状态查找部门
     * @return result
     */
    @RequestMapping("/findDepartmentByStatus/{pageNum},{pageSize}")
    public ResultPage findDepartmentByStatus(@PathVariable("pageNum")int pageNum,
                                             @PathVariable("pageSize")int pageSize,
                                             int departmentStatus){
        return departmentService.findDepartmentByStatus(departmentStatus,pageNum,pageSize);
    }

    /**
     * 查找所有的部门信息
     * @return result
     */
    @RequestMapping("/findAllDepartment/{pageNum},{pageSize}")
    public ResultPage findAllDepartment(@PathVariable("pageNum")int pageNum,
                                        @PathVariable("pageSize")int pageSize){
       return departmentService.findAllDepartment(pageNum,pageSize);
    }
}
