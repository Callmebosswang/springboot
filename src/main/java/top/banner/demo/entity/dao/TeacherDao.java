package top.banner.demo.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.banner.demo.entity.Teacher;


public interface TeacherDao extends JpaRepository<Teacher, Integer> {
}
