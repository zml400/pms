package com.pms.controller;

import com.pms.entity.Result;
import com.pms.entity.User;
import com.pms.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 用户注册
     * @param user
     * @return result
     */
    @RequestMapping("/register")
    public Result register(User user){
        Result result = userService.addUser(user);
        return result;
    }

    /**
     * 用户登陆
     * @param userName
     * @param userPassword
     * @return result
     */
    @RequestMapping("/login")
    public Result login(String userName,String userPassword){
        Result result = userService.login(userName,userPassword);
        return  result;
    }

    /**
     *  删除用户
     * @param userId
     * @return result
     */
    @RequestMapping("/deleteUser")
    public Result deleteUser(int userId){
        Result result =userService.deleteUser(userId);
        return result;
    }

    /**
     * 根据用户名查找用户
     * @param userName
     * @return result
     */
    @RequestMapping("/findUserByName")
    public Result findUser(String userName){
        Result result = userService.findUserByName(userName);
        return  result;
    }

    /**
     *  根据状态查找用户
     * @param userStatus
     * @return result
     */
    @RequestMapping("/findUserByStatus")
    public Result findUser(int userStatus){
        Result result = userService.findUserByStatus(userStatus);
        return  result;
    }

    /**
     * 查找所有用户
     * @return result
     */
    @RequestMapping("/findAllUser")
    public Result findAllUser(){
        Result result =userService.findAllUser();
        return result;
    }
}
