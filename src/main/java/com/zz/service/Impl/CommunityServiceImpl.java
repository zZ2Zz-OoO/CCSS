package com.zz.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.mapper.CommunityMapper;
import com.zz.pojo.Community;
import com.zz.service.CommunityService;
import org.springframework.stereotype.Service;

@Service
public class CommunityServiceImpl extends ServiceImpl<CommunityMapper, Community> implements CommunityService {
}
