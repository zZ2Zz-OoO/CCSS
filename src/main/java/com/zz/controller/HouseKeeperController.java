package com.zz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.pojo.Housekeeper;
import com.zz.pojo.R;
import com.zz.service.HouseKeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/housekeepers")
public class HouseKeeperController {
    @Autowired
    private HouseKeeperService houseKeeperService;

    @PostMapping("/login")
    public R<Housekeeper> login(HttpServletRequest request, @RequestBody Housekeeper housekeeper) {


        String password = DigestUtils.md5DigestAsHex(housekeeper.getPassword().getBytes());
        QueryWrapper<Housekeeper> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("house_keeper_name", housekeeper.getHouseKeeperName());
        Housekeeper one = houseKeeperService.getOne(queryWrapper);

        if (one == null) {
            return R.error("登录失败");
        }
        if (!one.getPassword().equals(password)) {
            return R.error("登陆失败");
        }

        request.getSession().setAttribute("user", one.getHouseKeepingId());
        return R.success(one);
    }

    @PostMapping
    public R<String> addUser(@RequestBody Housekeeper housekeeper) {

        housekeeper.setPassword(DigestUtils.md5DigestAsHex(housekeeper.getPassword().getBytes()));
        houseKeeperService.save(housekeeper);
        return R.success("新增用户成功");

    }
}
