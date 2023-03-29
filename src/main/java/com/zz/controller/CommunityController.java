package com.zz.controller;

import com.zz.pojo.Community;
import com.zz.pojo.R;
import com.zz.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("communitys")
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    @PostMapping
    public R<String> addCommunity(@RequestBody Community community) {
        boolean save = communityService.save(community);
        if (save) {
            return R.success("添加社区成功");
        }
        else {
            return R.error("添加社区失败");
        }
    }

    @DeleteMapping("/{community_id}")
    public R<String> deleteOne(@PathVariable BigInteger community_id) {
        boolean b = communityService.removeById(community_id);
        if (b) {
            return R.success("删除成功");
        }
        else {
            return R.error("删除失败");
        }
    }

    @GetMapping("/{community_id}")
    public R<Community> getById(@PathVariable BigInteger community_id) {
        Community community = communityService.getById(community_id);
        if (community != null) {
            return R.success(community);
        }
        return R.error("无此社区");
    }

    @GetMapping
    public R<List<Community>> getAll() {
        List<Community> communities = communityService.list();
        return R.success(communities);
    }

    @PutMapping
    public R<String> update(@RequestBody Community community) {
        boolean flag = communityService.updateById(community);
        if (flag) {
            return R.success("修改成功");
        }
        else {
            return R.error("修改失败");
        }
    }
}
