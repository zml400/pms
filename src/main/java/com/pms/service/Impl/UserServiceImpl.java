package com.pms.service.Impl;

import com.pms.entity.Result;
import com.pms.entity.User;
import com.pms.mapper.UserMapper;
import com.pms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     * @param user
     * @return Result
     */
    @Override
    public Result addUser(User user) {
        Result result = new Result();
        if(user==null){
            result.setCode(1);
            result.setMessage("输入为空，注册失败");
            return result;
        }
        if(user.getUserName().isEmpty()){
            result.setCode(1);
            result.setMessage("姓名为空，注册失败");
            return result;
        }else{
            User user1=userMapper.findUserByName(user.getUserName());
            if(user1!=null){
                result.setCode(1);
                result.setMessage("名字已存在，请重新输入");
                return result;
            }
        }
        if(user.getUserPassword().isEmpty()){
            result.setCode(1);
            result.setMessage("密码为空，请重新输入");
            return result;
        }
        int num=userMapper.addUser(user);
        if(num==0){
            result.setCode(1);
            result.setMessage("添加失败");
        }else {
            result.setCode(0);
            result.setMessage("注册成功");
            result.setData(user);
        }
        return result;
    }


    /**
     * 用户登陆
     * @param userName
     * @param userPassword
     * @return Result
     */
    @Override
    public Result login(String userName, String userPassword) {
        Result result = new Result();
        User user=userMapper.findUserByName(userName);
        if(user==null){
            result.setCode(1);
            result.setMessage("用户不存在");
            return  result;
        }
        if(!(user.getUserPassword().equals(userPassword))){
            result.setCode(1);
            result.setMessage("密码输入错误，请重新输入");
            return result;
        }
        result.setCode(0);
        result.setMessage(userName+"登陆成功");
        return result;
    }

    /**
     * 删除用户
     * @param userId
     * @return Result
     */
    @Override
    public Result deleteUser(int userId) {
        Result result = new Result();
        int num=userMapper.deleteUser(userId);
        if(num==0){
            result.setCode(1);
            result.setMessage("删除失败");
        }else {
            result.setCode(0);
            result.setMessage("删除成功");
        }
        return result;
    }

    /**
     * 更新用户
     * @param user
     * @return Result
     */
    @Override
    public Result updateUser(User user) {

        Result result = new Result();
        int num=userMapper.updateUser(user);
        if(num==0){
            result.setCode(1);
            result.setMessage("更新失败");
        }else{
            result.setCode(0);
            result.setMessage("更新成功");
            result.setData(user);
        }
        return result;
    }
    @Override
    public Result findUserById(int userId){
        Result result = new Result();
        User user = userMapper.findUserById(userId);
        if(user==null){
            result.setCode(1);
            result.setMessage("您输入的用户名错误，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(user);
        }
        return result;
    }
    @Override
    public Result findUserByName(String userName){
        Result result = new Result();
        User user = userMapper.findUserByName(userName);
        if(user==null){
            result.setCode(1);
            result.setMessage("您输入的用户名错误，请重新输入");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(user);
        }
        return result;
    }

    @Override
    public Result findUserByStatus(int userStatus){
        Result result = new Result();
        List<User> userList=userMapper.findUserByStatus(userStatus);
        if(userList.size()==0){
            result.setCode(1);
            result.setData("没有找到相应记录");
        }else {
            result.setCode(0);
            result.setMessage("查找成功");
            result.setData(userList);
        }
        return result;
    }
    @Override
    public Result findAllUser(){
        Result result = new Result();
        List<User> userList = userMapper.findAllUser();
        result.setCode(0);
        result.setMessage("查找成功");
        result.setData(userList);
        return result;
    }
}
