package com.shaopeng.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.shaopeng.mapper.UserMapper;
import com.shaopeng.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusUpdateWrapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test_01(){
        //将年龄大于20并且用户名中包含a或者邮箱为null的用户信息修改
        //QueryWrapper修改【条件】
        //1，准备要修改的实体类对象
        //2，不能改为null
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.gt("age",20)
                .like("name","a")
                .or().isNull("email");//条件直接调用方法默认使用and 拼接


        //要修改的数据
        User user=new User();
        user.setAge(88);
        user.setEmail("hehehehe");
        userMapper.update(user,queryWrapper);
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


        //要修改的数据

        userMapper.update(null,updateWrapper);
    }
}
