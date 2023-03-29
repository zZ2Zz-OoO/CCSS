package com.zz.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.mapper.ServiceOrderServiceMapper;
import com.zz.pojo.ServiceOrder;
import com.zz.service.ServiceOrderService;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrderServiceImpl extends ServiceImpl<ServiceOrderServiceMapper, ServiceOrder> implements ServiceOrderService {
}
