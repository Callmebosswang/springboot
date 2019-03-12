package top.banner.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.banner.demo.entity.User;
import top.banner.demo.entity.dao.UserDao;

import javax.websocket.server.PathParam;

@RestController
public class Hello {
    @Autowired
    public UserDao userDao;

    @GetMapping("/")
    public User hello(){
        return userDao.save(new User("张三","sdfa"));
    }

    @GetMapping("/{id}")
    public User go(@PathParam("id") Integer id){
        return userDao.findByNickName("张三");
    }


}
