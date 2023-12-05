package com.shaopeng.test;

import com.shaopeng.mapper.UserMapper;
import com.shaopeng.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test_insert(){
        User user = new User();
        user.setAge(88);
        user.setName("呵呵呵");
        user.setEmail("2114363815@qq.com");
        //baseMapper提供的数据库操作插入方法
        int rows = userMapper.insert(user);
    }
    @Test
    public void test_delete1(){
        //根据id删除
        int rows = userMapper.deleteById(1731131986581483522L);
        System.out.println("rows = " + rows);
        //根据age=20删除
        Map param=new HashMap<>();
        param.put("age",20);
        int i = userMapper.deleteByMap(param);
        System.out.println("i = " + i);


//        wrapper条件封装对象，无限的封装
//        userMapper.delete(wrapper);


    }
    @Test
    public void test_update(){
        //TODO: update 当属性值为null的时候，不修改
        //updatebyId实体类id必须有值
        //user id=1的age改为30
        User user=new User();
        user.setId(1L);
        user.setAge(30);
        //update user set age=30 where id=1
        int i = userMapper.updateById(user);
        System.out.println("i = " + i);


        //将所有人的年龄改为22
        //update实体类可以没有id值
        User user1=new User();
        user1.setAge(22);
        int rows=userMapper.update(user,null);//null没条件
        System.out.println("rows = " + rows);
    }
    @Test
    public void test_select(){
        //根据id查询
        User user=userMapper.selectById(1);
        //根据id集合查询
        List<Long> ids=new ArrayList<>();
        ids.add(1L); ids.add(2L);
        List<User> users = userMapper.selectBatchIds(ids);
        System.out.println("users = " + users);

    }

}
