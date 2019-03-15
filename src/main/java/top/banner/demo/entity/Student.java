package top.banner.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author: XGL
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_student")
public class Student extends UserInfo {
    private String clazz;

    public Student(Integer role) {
        super(role);
    }
}
