package com.pms.mapper;

import com.pms.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public int addUser(User user);
    public int deleteUser(int userId);
    public int updateUser(User user);
    public User findUserById(int userId);
    public User findUserByName(String userName);
    public List<User> findUserByStatus(int userStatus);
    public List<User> findAllUser();
}
