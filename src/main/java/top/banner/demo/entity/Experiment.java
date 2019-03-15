package top.banner.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "experiment", cascade = {CascadeType.ALL}, orphanRemoval = true, targetEntity = ExperimentSchedule.class)
    @MapKey(name = "student")
    private Map<Student, ExperimentSchedule> schedule = new HashMap();

    @Column(length = 50)
    private String classRoom;

    @ManyToOne
    private Teacher teacher;

    /**
     * 实验标题
     */
    @Column(length = 100)
    private String title;

    /**
     * 实验内容
     */
    @Lob
    private String content;

    /**
     * 实验资料（本来应该关联一个新的类的，但是懒的写了）
     * 可以存富文本。
     */
    @Lob
    private String data;


}
