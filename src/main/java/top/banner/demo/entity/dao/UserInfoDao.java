package top.banner.demo.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.banner.demo.entity.UserInfo;


public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {
    UserInfo findByAccount(String account);
}
