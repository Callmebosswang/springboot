package top.banner.demo.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.banner.demo.entity.ExperimentSchedule;

/**
 * @author: XGL
 */
public interface ExperimentScheduleDao extends JpaRepository<ExperimentSchedule, Integer> {
}
