package top.banner.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.banner.demo.entity.Student;
import top.banner.demo.entity.User;
import top.banner.demo.entity.dao.StudentDao;
import top.banner.demo.entity.dao.UserDao;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

@RestController
public class Hello {
    @Resource
    public UserDao userDao;
    @Resource
    private StudentDao studentDao;

    @GetMapping("/")
    public Student hello() {
        Student student = new Student();
        student.setAge(10);
        student.setClasszz("一年级");

        User user = new User();
        user.setAccount("user1");


        User user1 = new User();
        user1.setAccount("user2");
        user1.setAge(13);
        userDao.save(user);
        userDao.save(user1);

        return studentDao.save(student);
    }

    @GetMapping("/{id}")
    public User go(@PathParam("id") Integer id) {
        return userDao.findByNickName("张三");
    }


}
