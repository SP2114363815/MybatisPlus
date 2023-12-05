package com.shaopeng.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.shaopeng.mapper.UserMapper;
import com.shaopeng.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusLambdaQueryWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test_01(){
        //查询用户名包含 a like,年龄在20-30之间，并且邮箱不为空的用户信息
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        //条件  动态调用wrapper的方法完成拼接即可

        //链式调用
        queryWrapper.like("name","a").between("age",20,30).isNotNull("email");
        //
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,"a").between(User::getAge,20,30).isNotNull(User::getEmail);
        userMapper.selectList(lambdaQueryWrapper);
    }



    @Test
    public void test_02(){
        //将年龄大于20并且用户名中包含a或者邮箱为null的用户信息修改
        //UpdateWrapper修改[条件，修改]
        //1，直接携带修改数据 set("列名","值")
        //2，指定任意修改值
        UpdateWrapper<User> updateWrapper=new UpdateWrapper<>();
        updateWrapper.gt("age",20)
                .like("name","a")
                .or().isNull("email").set("email",null).set("age",99);//条件直接调用方法默认使用and 拼接
        LambdaUpdateWrapper<User> lambdaUpdateWrapper=new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.gt(User::getAge,20)
                .like(User::getName,"a")
                .or().isNull(User::getEmail)
                .set(User::getEmail,null).set(User::getAge,99);
        //要修改的数据
        userMapper.update(null,lambdaUpdateWrapper);
    }
}
