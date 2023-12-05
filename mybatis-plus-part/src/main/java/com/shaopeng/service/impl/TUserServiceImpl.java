package com.shaopeng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shaopeng.pojo.TUser;
import com.shaopeng.service.TUserService;
import com.shaopeng.mapper.TUserMapper;
import org.springframework.stereotype.Service;

/**
* @author 邵
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2023-12-04 12:15:44
*/
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser>
    implements TUserService{

}




