package com.aiden.sringbootrestful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RequestMapping("/user")
@Controller
public class UserController {

    @PostMapping("/login")
    public String login(String username, String password
            , HashMap<String, Object> model
            , HttpSession session) {
        if (StringUtils.isEmpty(username) || !"123456".equals(password)) {
            model.put("code", -1);
            model.put("msg", "账号密码错误");
        } else {
            session.setAttribute("loginUser", username);
            //重定向到首页
            return "redirect:/main.html";
        }
        return "index";
    }

}
