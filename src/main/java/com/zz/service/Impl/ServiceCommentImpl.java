package com.zz.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.mapper.ServiceCommentMapper;
import com.zz.pojo.ServiceComment;
import com.zz.service.ServiceCommentService;
import org.springframework.stereotype.Service;

@Service
public class ServiceCommentImpl extends ServiceImpl<ServiceCommentMapper, ServiceComment> implements ServiceCommentService {
}
