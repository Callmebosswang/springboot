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

    /**
     * 进度
     */
    @Column(length = 5)
    private Integer schedule = 0;

    /**
     * 分数
     */
    @Column(length = 5)
    private Integer fraction;

    /**
     * 评语
     */
    @Column(length = 200)
    private String comment;


}
