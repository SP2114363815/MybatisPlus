package com.shaopeng.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shaopeng.mapper.UserMapper;
import com.shaopeng.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusQueryWrapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test_01(){
        //查询用户名包含 a like,年龄在20-30之间，并且邮箱不为空的用户信息
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        //条件  动态调用wrapper的方法完成拼接即可
        queryWrapper.like("name","a");
        queryWrapper.between("age",20,30);
        queryWrapper.isNotNull("email");
        //链式调用
        //queryWrapper.like("name","a").between("age",20,30).isNotNull("email");
        userMapper.selectList(queryWrapper);
    }
    @Test
    public void test_02(){
        //按年龄降序查询用户，如果年龄相同则按id升序排列
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("id");
        //最终结果order by age desc ,id asc;
        List<User> users = userMapper.selectList(queryWrapper);
    }
    @Test
    public void test_03(){
        //删除Email为空的用户
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.isNull("email");
        userMapper.delete(queryWrapper);
    }

    @Test
    public void test_04(){
        //将年龄大于20并且用户名中包含a或者邮箱为null的用户信息修改
        //
        User user=new User();
        user.setAge(88);
        user.setEmail("hehehehe");
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.gt("age",20)
                .like("name","a")
                .or().isNull("email");//条件直接调用方法默认使用and 拼接
        userMapper.update(user,queryWrapper);
    }
    @Test
    public void test_05(){
        //查询指定列
        //查询用户信息的name和age字段
        //select username，age from t_user
        //默认查询的是全部列
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("id",1L);
        queryWrapper.select("name","age");//指定查询的列
        userMapper.selectList(queryWrapper);
    }

    @Test
    public void test_06(){
        //前端传入两个参数 name age
        //name不为空，作为条件=查询
        //age》18，作为条件，查询age=
        String name="王五";
        Integer age=18;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(name)){
            //动态条件判断
            queryWrapper.eq("name",name);
        }

        if (age!=null && age>18){
            queryWrapper.eq("age",age);
        }

        //每个方法都有一个Boolean condition，允许我们第一位放一个比较表达式 true 整个条件生效 false 不生效
        //ge(boolean condition,R column,Object vol)
        queryWrapper.eq(StringUtils.isNotBlank(name),"name",name);
        queryWrapper.eq(age!=null && age>18,"age",age);

        userMapper.selectList(queryWrapper);
    }
}
