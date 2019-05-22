package com.pms.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pms.VO.Result;
import com.pms.VO.ResultPage;
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
        if(user==null){
            return Result.failed("输入为空，注册失败");
        }
        if(user.getUserName().isEmpty()){
            return Result.failed("姓名为空，注册失败");
        }else{
            User user1=userMapper.findUserByName(user.getUserName());
            if(user1!=null){
                return Result.failed("名字已存在，请重新输入");
            }
        }
        if(user.getUserPassword().isEmpty()){
            return Result.failed("密码为空，请重新输入");
        }
        int num=userMapper.addUser(user);
        if(num==0){
            return Result.failed("添加失败");
        }else {
            return Result.success("注册成功",user);
        }
    }


    /**
     * 用户登陆
     * @param userName
     * @param userPassword
     * @return Result
     */
    @Override
    public Result login(String userName, String userPassword) {
        User user=userMapper.findUserByName(userName);
        if(user==null){
            return  Result.failed("用户不存在");
        }
        if(!(user.getUserPassword().equals(userPassword))){
            return Result.failed("密码输入错误，请重新输入");
        }
        return Result.success(userName+"登陆成功");
    }

    /**
     * 删除用户
     * @param userId
     * @return Result
     */
    @Override
    public Result deleteUser(int userId) {
        int num=userMapper.deleteUser(userId);
        if(num==0){
            return Result.failed("删除失败");
        }else {
            return Result.success("删除成功");
        }
    }

    /**
     * 更新用户
     * @param user
     * @return Result
     */
    @Override
    public Result updateUser(User user) {
        int num=userMapper.updateUser(user);
        if(num==0){
            return Result.failed("更新失败");
        }else{
            return Result.success("更新成功",user);
        }
    }
    @Override
    public Result findUserById(int userId){
        User user = userMapper.findUserById(userId);
        if(user==null){
            return Result.failed("您输入的用户名错误，请重新输入");
        }else {
            return Result.success("查找成功",user);
        }
    }
    @Override
    public Result findUserByName(String userName){
        User user = userMapper.findUserByName(userName);
        if(user==null){
            return Result.failed("您输入的用户名错误，请重新输入");
        }else {
            return Result.success("查找成功",user);
        }
    }

    @Override
    public ResultPage findUserByStatus(int userStatus,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList=userMapper.findUserByStatus(userStatus);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        if(userList.size()==0){
            return ResultPage.failed("没有找到相应记录");
        }else {
            return ResultPage.success("查找成功",pageInfo.getTotal(),userList);
        }
    }
    @Override
    public ResultPage findAllUser(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList = userMapper.findAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        if(userList.size()==0){
            return ResultPage.failed("没有记录");
        }else{
            return ResultPage.success("查找成功",pageInfo.getTotal(),userList);
        }
    }
}
