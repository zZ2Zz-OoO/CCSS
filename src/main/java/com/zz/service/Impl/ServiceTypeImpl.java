package com.zz.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.mapper.ServiceTypeMapper;
import com.zz.pojo.ServiceType;
import com.zz.service.ServiceTypeService;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeImpl extends ServiceImpl<ServiceTypeMapper, ServiceType> implements ServiceTypeService {
}
