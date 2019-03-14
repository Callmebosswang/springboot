package top.banner.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: XGL
 * 实验
 */
@Data
@Entity
@Table(name = "tb_experiment")
public class Experiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "experiment", cascade = {CascadeType.ALL}, orphanRemoval = true, targetEntity = ExperimentSchedule.class)
    @MapKey(name = "student")
    private Map schedule = new HashMap<Student, ExperimentSchedule>();

}
