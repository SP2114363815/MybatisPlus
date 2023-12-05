package com.shaopeng.test;

import com.shaopeng.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//测试逻辑删除
@SpringBootTest
public class MybatisPlusTableLogicTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test_01(){
        userMapper.deleteById(1);

        userMapper.selectList(null);
    }
}
