package top.banner.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author xgl
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 密码
     */
    @Column(length = 50)
    private String password;

    /**
     * 账号
     */
    @Column(length = 50)
    private String account;

    /**
     * 昵称
     */
    @Column(length = 50)
    private String nickName;

    /**
     * 真实姓名
     */
    @Column(length = 10)
    private String name;

    /**
     * 性别  0-未知 1-男 2-女
     */
    @Column(length = 10)
    private Sex sex = Sex.UNKNOWN;

    /**
     * 年龄
     */
    @Column(length = 5)
    private Integer age;

    /**
     * 头像
     */
    @Column(length = 50)
    private String avatarUrl;

    /**
     * 电话号码
     */
    @Column(length = 11)
    private String tel;


}
