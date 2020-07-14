package com.aiden.sringbootrestful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;

@Controller
public class UserController {

    @PostMapping("/login")
    public String login(String username, String password, HashMap<String, Object> model) {
        if (!StringUtils.isEmpty(username)) {
            model.put("code", -1);
            model.put("msg", "账号密码为空");
        }
        if ("123456".equals(password)) {
            model.put("code", 0);
            model.put("msg", "登录成功");
        } else {
            model.put("code", -1);
            model.put("msg", "账号密码错误");
        }

        return "index";
    }


}
