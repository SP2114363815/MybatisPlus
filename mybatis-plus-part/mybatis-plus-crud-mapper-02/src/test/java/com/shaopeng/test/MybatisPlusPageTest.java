package com.shaopeng.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shaopeng.mapper.UserMapper;
import com.shaopeng.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusPageTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testPage(){
        //IPage->Page(页码，页容量)
        Page<User> page=new Page<>(1,3);
        userMapper.selectPage(page,null);
        //结果 page最后也会被封装结果
        long current = page.getCurrent();//页码
        long size = page.getSize();//页容量
        List<User> records = page.getRecords();//当前页的数据
        long total = page.getTotal();//总条数
    }
    @Test
    public void testMyPage(){
        Page<User> page=new Page<>(1,3);
        userMapper.queryByAge(page,1);
        long current = page.getCurrent();//页码
        System.out.println("current = " + current);
        long size = page.getSize();//页容量
        System.out.println("size = " + size);
        List<User> records = page.getRecords();//当前页的数据
        System.out.println("records = " + records);
        long total = page.getTotal();//总条数
        System.out.println("total = " + total);
    }
}
