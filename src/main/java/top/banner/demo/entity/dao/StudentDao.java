package top.banner.demo.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.banner.demo.entity.UserInfo;


public interface StudentDao extends JpaRepository<UserInfo, Integer> {
}
