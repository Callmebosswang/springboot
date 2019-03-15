package top.banner.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xgl
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_teacher")
public class Teacher extends UserInfo {

    /**
     * 发布的实验
     */
    @OneToMany(targetEntity = Experiment.class)
    @JoinTable(name = "tb_teacher_experiment")
    private List experiments = new ArrayList<Experiment>();



    public Teacher(Integer role) {
        super(role);
    }
}
