package com.shaopeng.test;

import com.shaopeng.pojo.User;
import com.shaopeng.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest
public class MybatisPlusServiceTest {

    @Autowired
    private UserService userService;
    @Test
    public void  test_save(){
        List<User> list=new ArrayList<>();
        User user=new User();
        user.setAge(18);
        user.setEmail("jj");
        user.setName("呵呵呵");
        list.add(user);

        User user1=new User();
        user1.setAge(19);
        user1.setEmail("jj");
        user1.setName("驴蛋蛋");
        list.add(user1);

        boolean b = userService.saveBatch(list);
        System.out.println("b = " + b);
    }

    @Test
    public void  test_saveOrUpdate(){
        //如果id不为空就修改，为空就插入
        User user=new User();
        user.setAge(18);
        user.setEmail("jj");
        user.setName("呵呵呵222");
        userService.saveOrUpdate(user);
    }

    @Test
    public void  test_remove(){

        boolean b = userService.removeById(1731146613465870338L);
        System.out.println("b = " + b);
    }

    @Test
    public void  test_update(){
        User user=new User();
        user.setAge(19);
        user.setEmail("jj");
        user.setName("驴蛋蛋");
        userService.updateById(user);
    }

    @Test
    public void  test_getOrList(){
        userService.getById(1L);//get返回的是单个对象
        userService.list(null);//查询全部返回的是集合
    }
}
