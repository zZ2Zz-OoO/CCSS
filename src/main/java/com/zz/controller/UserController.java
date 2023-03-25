package com.zz.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.pojo.R;
import com.zz.pojo.User;
import com.zz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R<User> login(HttpServletRequest request, @RequestBody User user) {


        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", user.getUserName());
        User one = userService.getOne(queryWrapper);

        if (one == null) {
            return R.error("登录失败");
        }
        if (!one.getPassword().equals(password)) {
            return R.error("登陆失败");
        }

        request.getSession().setAttribute("user", one.getUserId());
        return R.success(one);
    }


    @PostMapping
    public R<String> addUser(HttpServletRequest request, @RequestBody User user) {

        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        user.setCardId(DigestUtils.md5DigestAsHex(user.getCardId().getBytes()));
//        Long CardId = (Long) request.getSession().getAttribute("user");

        userService.save(user);
        return R.success("新增用户成功");

    }

    @GetMapping("/{user_id}")
    public R<User> getById(@PathVariable BigInteger user_id) {
        User user = userService.getById(user_id);
        if (user != null) {
            return R.success(user);
        }
        return R.error("没有查询到此员工");
    }

    @GetMapping
    public R<List<User>> getAll() {
        List<User> users = userService.list();
        return R.success(users);
    }

    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return R.success("退出成功");
    }


}
