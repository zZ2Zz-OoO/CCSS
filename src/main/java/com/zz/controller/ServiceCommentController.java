package com.zz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.pojo.R;
import com.zz.pojo.ServiceComment;
import com.zz.service.ServiceCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class ServiceCommentController {
    @Autowired
    private ServiceCommentService serviceCommentService;

    @PostMapping
    public R<String> addServiceComment(@RequestBody ServiceComment ServiceComment) {
        boolean save = serviceCommentService.save(ServiceComment);
        if (save) {
            return R.success("评论成功");
        }
        else {
            return R.error("评论失败");
        }
    }

    @DeleteMapping("/{serviceComment_id}")
    public R<String> deleteOne(@PathVariable Integer serviceComment_id) {
        boolean b = serviceCommentService.removeById(serviceComment_id);
        if (b) {
            return R.success("删除成功");
        }
        else {
            return R.error("删除失败");
        }
    }

    @GetMapping("/{serviceOrder_id}")
    public R<ServiceComment> getById(@PathVariable Integer serviceOrder_id) {

        QueryWrapper<ServiceComment> QueryWrapper = new QueryWrapper<>();
        QueryWrapper.eq("service_order_id", serviceOrder_id);

        ServiceComment ServiceComment = serviceCommentService.getOne(QueryWrapper);
        if (ServiceComment != null) {
            return R.success(ServiceComment);
        }
        return R.error("无此评论");
    }

    @GetMapping
    public R<List<ServiceComment>> getAll() {
        List<ServiceComment> ServiceComments = serviceCommentService.list();
        return R.success(ServiceComments);
    }

//    @PutMapping
//    public R<String> update(@RequestBody ServiceComment ServiceComment) {
//        boolean flag = serviceCommentService.updateById(ServiceComment);
//        if (flag) {
//            return R.success("修改成功");
//        }
//        else {
//            return R.error("修改失败");
//        }
//    }
}
