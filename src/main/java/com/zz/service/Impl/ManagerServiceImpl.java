package com.zz.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.mapper.ManagerMapper;
import com.zz.pojo.Manager;
import com.zz.service.ManagerService;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {
}
