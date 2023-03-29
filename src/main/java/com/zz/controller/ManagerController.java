package com.zz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.pojo.Manager;
import com.zz.pojo.R;
import com.zz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerservice;

    @PostMapping("/login")
    public R<Manager> login(HttpServletRequest request, @RequestBody Manager manager) {


        String password = DigestUtils.md5DigestAsHex(manager.getPassword().getBytes());

        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("manager_name", manager.getManagerName());
        Manager one = managerservice.getOne(queryWrapper);

        if (one == null) {
            return R.error("登录失败");
        }
        if (!one.getPassword().equals(password)) {
            return R.error("登陆失败");
        }

        request.getSession().setAttribute("manager", one.getManagerId());
        return R.success(one);
    }

    @PostMapping
    public R<String> addManager(@RequestBody Manager manager) {

        manager.setPassword(DigestUtils.md5DigestAsHex(manager.getPassword().getBytes()));
        managerservice.save(manager);
        return R.success("新增管理员成功");

    }

    @GetMapping("/{manager_id}")
    public R<Manager> getById(@PathVariable BigInteger manager_id) {
        Manager manager = managerservice.getById(manager_id);
        if (manager != null) {
            return R.success(manager);
        }
        return R.error("没有查询到此管理员");
    }

    @GetMapping
    public R<List<Manager>> getAll() {
        List<Manager> managers = managerservice.list();
        return R.success(managers);
    }

    @PutMapping
    public R<String> update(@RequestBody Manager manager) {
        boolean flag = managerservice.updateById(manager);
        if (flag) {
            return R.success("修改成功");
        }
        else {
            return R.error("修改失败");
        }
    }


    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("Manager");
        return R.success("退出成功");
    }

}
