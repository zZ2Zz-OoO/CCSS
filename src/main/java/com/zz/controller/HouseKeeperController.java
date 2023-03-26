package com.zz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.pojo.Housekeeper;
import com.zz.pojo.R;
import com.zz.service.HouseKeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;

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

        request.getSession().setAttribute("houseKeeper", one.getHouseKeepingId());
        return R.success(one);
    }

    @PostMapping
    public R<String> addUser(@RequestBody Housekeeper housekeeper) {

        housekeeper.setPassword(DigestUtils.md5DigestAsHex(housekeeper.getPassword().getBytes()));
        houseKeeperService.save(housekeeper);
        return R.success("新增用户成功");

    }

    @GetMapping
    public R<List<Housekeeper>> getAll() {
        List<Housekeeper> housekeepers = houseKeeperService.list();
        return R.success(housekeepers);
    }

    @PutMapping
    public R<String> update(@RequestBody Housekeeper housekeeper) {
        boolean flag = houseKeeperService.updateById(housekeeper);
        if (flag) {
            return R.success("修改成功");
        }
        else {
            return R.error("修改失败");
        }
    }

    @GetMapping("/{house_keeper_id}")
    public R<Housekeeper> getById(@PathVariable BigInteger house_keeper_id) {
        Housekeeper housekeeper = houseKeeperService.getById(house_keeper_id);
        if (housekeeper != null) {
            return R.success(housekeeper);
        }
        return R.error("没有查询到此员工");
    }

    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("houseKeeper");
        return R.success("退出成功");
    }
}
