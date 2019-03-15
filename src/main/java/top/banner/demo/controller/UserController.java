package top.banner.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.banner.demo.entity.UserInfo;
import top.banner.demo.service.UserService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: XGL
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 注册
     */
    @PostMapping("/register")
    public UserInfo register(@RequestBody Map<String, Object> map) {
        return userService.register(map);
    }

    /**
     * 登陆
     */
    @PostMapping("/login")
    public UserInfo login(@RequestBody Map<String, Object> map) {
        return userService.login(map);
    }

}
