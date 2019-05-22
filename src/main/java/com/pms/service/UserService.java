package com.pms.service;

import com.pms.VO.Result;
import com.pms.VO.ResultPage;
import com.pms.entity.User;

public interface UserService {
    public Result addUser(User user);
    public Result login(String userName,String userPassword);
    public Result deleteUser(int userId);
    public Result updateUser(User user);
    public Result findUserById(int userId);
    public Result findUserByName(String userName);
    public ResultPage findUserByStatus(int userStatus, int pageNum, int pageSize);
    public ResultPage findAllUser(int pageNum,int pageSize);
}
