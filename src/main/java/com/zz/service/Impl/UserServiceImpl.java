package com.zz.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.mapper.UserMapper;
import com.zz.pojo.User;
import com.zz.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
