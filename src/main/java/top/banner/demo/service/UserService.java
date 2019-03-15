package top.banner.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import top.banner.demo.entity.Student;
import top.banner.demo.entity.Teacher;
import top.banner.demo.entity.UserInfo;
import top.banner.demo.entity.dao.UserInfoDao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: XGL
 */
@Service
public class UserService {
    @Resource
    private UserInfoDao userInfoDao;


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
                userInfo = new Student();
                break;
            case 1:
                userInfo = new Teacher();
                break;
            default:
                throw new RuntimeException();
        }

        userInfo.setName(map.get("name").toString().trim());
        userInfo.setAccount(map.get("account").toString().trim());
        userInfo.setPassword(map.get("password").toString().trim());
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

}


