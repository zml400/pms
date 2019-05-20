package com.pms.mapper;

import com.pms.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DepartmentMapper {
    public int addDepartment(Department department);
    public int deleteDepartment(int departmentId);
    public int updateDepartment(Department department);
    public Department findDepartmentById(int departmentId);
    public Department findDepartmentByName(String departmentName);
    public List<Department> findDepartmentByStatus(int departmentStatus);
    public List<Department> findAllDepartment();

}
