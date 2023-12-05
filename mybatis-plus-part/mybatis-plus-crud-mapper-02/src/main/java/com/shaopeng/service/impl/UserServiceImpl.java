package com.shaopeng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shaopeng.mapper.UserMapper;
import com.shaopeng.pojo.User;
import com.shaopeng.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService  {
}
