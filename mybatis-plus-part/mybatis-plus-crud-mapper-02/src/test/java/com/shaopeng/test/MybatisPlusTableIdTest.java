package com.shaopeng.test;

import com.shaopeng.mapper.UserMapper;
import com.shaopeng.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusTableIdTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public  void test_01(){
        User user=new User();
        user.setName("呵呵呵");
        user.setAge(23);
        user.setEmail("2114363815@qq.com");
        //主键不用赋值
        //主键的策略：雪花算法-》不重复的数字 long
        userMapper.insert(user);
    }
}
