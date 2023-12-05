package com.shaopeng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shaopeng.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {


    //定义一个根据年龄参数查询，并且分页的方法 age>xx
    IPage<User> queryByAge(IPage<User> page,@Param("age") Integer age);
}
