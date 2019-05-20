package com.pms.mapper;

import com.pms.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    public int addEmployee(Employee employee);
    public int deleteEmployee(int employeeId);
    public int updateEmployee(Employee employee);
    public Employee findEmployeeById(int employeeId);
    public Employee findEmployeeByNumber(String employeeNumber);
    public Employee findEmployeeByName(String employeeName);
    public Employee findEmployeeByIdentityCard(String employeeIdentityCard);
    public Employee findEmployeeByPhone(String employeePhone);
    public List<Employee> findEmployeeByGender(String employeeGender);
    public List<Employee> findEmployeeByPosition(String employeePosition);
    public List<Employee> findEmployeeByDepartment(String employeeDepartment);
    public List<Employee> findEmployeeByStatus(int employeeStatus);
    public List<Employee> findAllEmployee();
}
