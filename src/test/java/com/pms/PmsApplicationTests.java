package com.pms;

import com.pms.entity.User;
import com.pms.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PmsApplicationTests {


    @Autowired
    private UserMapper userMapper;
    @Test
    public void contextLoads() {
    }

    @Test
    public void findByName(){
        System.out.println(userMapper.findUserById(1));
    }

}
