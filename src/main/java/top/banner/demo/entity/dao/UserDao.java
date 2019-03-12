package top.banner.demo.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.banner.demo.entity.User;

import java.util.List;


public interface UserDao extends JpaRepository<User,Integer> {
    public User findByNickName(String string);

}
