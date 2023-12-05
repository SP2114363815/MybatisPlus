package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SpringBootMybatisPlusTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test(){
        List<User> userList = userMapper.selectList(null);
        System.out.println("userList = " + userList);
    }
}
