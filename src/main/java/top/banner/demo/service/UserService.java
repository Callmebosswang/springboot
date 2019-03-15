package top.banner.demo.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import top.banner.demo.entity.Sex;
import top.banner.demo.entity.Student;
import top.banner.demo.entity.Teacher;
import top.banner.demo.entity.UserInfo;
import top.banner.demo.entity.dao.StudentDao;
import top.banner.demo.entity.dao.TeacherDao;
import top.banner.demo.entity.dao.UserInfoDao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author: XGL
 */
@Service
public class UserService {
    @Resource
    private UserInfoDao userInfoDao;
    @Resource
    private StudentDao studentDao;
    @Resource
    private TeacherDao teacherDao;

    /**
     * 检查是否有admin用户，没有就创建
     */
    @PostConstruct
    private void createAdmin() {
        UserInfo admin = userInfoDao.findByAccount("admin");
        if (admin == null) {
            admin = new UserInfo();
            admin.setAccount("admin");
            admin.setRole(3);
            admin.setPassword("admin");
            userInfoDao.save(admin);
        }

    }

    /**
     * 注册
     *
     * @param map
     * @return
     */
    @Transactional
    public UserInfo register(Map<String, Object> map) {
        Integer type = Integer.valueOf(map.get("type").toString());
        UserInfo userInfo;
        switch (type) {
            case 0:
                userInfo = new Student(0);
                break;
            case 1:
                userInfo = new Teacher(1);
                break;
            default:
                throw new RuntimeException();
        }

        userInfo.setName(map.get("name").toString().trim());
        userInfo.setAccount(map.get("account").toString().trim());
        userInfo.setPassword(map.get("password").toString().trim());
        userInfo.setAvatarUrl("http://www.gravatar.com/avatar/" + new Random().nextInt() + "?s=256&d=retro");
        userInfo.setAge(Integer.valueOf(map.get("age").toString()));

        return userInfoDao.save(userInfo);

    }

    /**
     * 登陆
     *
     * @param map
     * @return
     */
    @Transactional(readOnly = true)
    public UserInfo login(Map<String, Object> map) {
        UserInfo userInfo = userInfoDao.findByAccount(map.get("account").toString().trim());
        Assert.notNull(userInfo, "用户不存在");
        if (!userInfo.getPassword().equals(map.get("password").toString().trim())) {
            throw new RuntimeException("密码错误");
        }
        return userInfo;
    }

    /**
     * 修改用户信息
     *
     * @param id
     * @param map
     * @return
     */
    @Transactional
    public UserInfo update(Integer id, Map<String, ?> map) {
        UserInfo userInfo = userInfoDao.getOne(id);
        if (map.containsKey("age"))
            userInfo.setAge(Integer.valueOf(map.get("age").toString()));
        if (map.containsKey("nickName"))
            userInfo.setNickName(map.get("nickName").toString());
        if (map.containsKey("sex"))
            userInfo.setSex(Sex.values()[Integer.valueOf(map.get("sex").toString())]);
        if (map.containsKey("tel"))
            userInfo.setTel(map.get("tel").toString());
        return userInfoDao.save(userInfo);
    }

    /**
     * 用户详情
     *
     * @param id
     * @return
     */
    public UserInfo detail(Integer id) {
        return userInfoDao.getOne(id);
    }

    /**
     * 学生列表
     *
     * @return
     */
    public List<Student> students() {
        return studentDao.findAll();
    }

    /**
     * 老师列表
     *
     * @return
     */
    public List<Teacher> teachers() {
        return teacherDao.findAll(Sort.by("id").descending());
    }
}


