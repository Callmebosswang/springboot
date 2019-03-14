package top.banner.demo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: XGL
 */
@Data
@Entity
@Table(name = "tb_experiment_schedule")
public class ExperimentSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = Experiment.class)
    private Experiment experiment;

    @ManyToOne(targetEntity = Student.class)
    private Student student;
}
