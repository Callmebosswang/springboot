package top.banner.demo.controller;

import org.springframework.web.bind.annotation.*;
import top.banner.demo.entity.Student;
import top.banner.demo.entity.Teacher;
import top.banner.demo.entity.UserInfo;
import top.banner.demo.service.UserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author: XGL
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 注册，添加用户
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

    /**
     * 修改用户信息
     */
    @PutMapping("/userInfos/{id}")
    public UserInfo update(@PathVariable Integer id, @RequestBody Map<String, ?> map) {
        return userService.update(id, map);
    }

    /**
     * 获取用户详情
     */
    @GetMapping("/userInfos/{id}")
    public UserInfo detail(@PathVariable Integer id) {
        return userService.detail(id);
    }

    /**
     * 获取学生列表
     */
    @GetMapping("/students")
    public List<Student> students() {
        return userService.students();
    }


    /**
     * 获取老师列表
     */
    @GetMapping("/teachers")
    public List<Teacher> teachers() {
        return userService.teachers();
    }


    /**
     * 修改密码
     */
    @PutMapping("/userInfos/{id}/password")
    public UserInfo resetPassword(@PathVariable Integer id, @RequestBody Map<String, ?> map) {
        return userService.resetPassword(id, map);
    }



    @DeleteMapping("/userInfos/{id}")
    public void deleteUsers(@PathVariable Integer id){
        userService.delete(id);
    }

}
