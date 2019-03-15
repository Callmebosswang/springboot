package top.banner.demo.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.banner.demo.entity.Experiment;


public interface ExperimentDao extends JpaRepository<Experiment, Integer> {
}
