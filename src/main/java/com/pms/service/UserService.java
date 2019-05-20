package com.pms.service;

import com.pms.entity.Result;
import com.pms.entity.User;

public interface UserService {
    public Result addUser(User user);
    public Result login(String userName,String userPassword);
    public Result deleteUser(int userId);
    public Result updateUser(User user);
    public Result findUserById(int userId);
    public Result findUserByName(String userName);
    public Result findUserByStatus(int userStatus);
    public Result findAllUser();
}
