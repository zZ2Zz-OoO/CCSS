package com.zz.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.mapper.HouseKeeperMapper;
import com.zz.pojo.Housekeeper;
import com.zz.service.HouseKeeperService;
import org.springframework.stereotype.Service;

@Service
public class HouseKeeperServiceImpl extends ServiceImpl<HouseKeeperMapper, Housekeeper> implements HouseKeeperService {
}
