package top.banner.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author jinguoguo
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nickName;

    private String name;

    private String sex;

    private Integer age;

    private String avatarUrl;
    private String tel;
    private Integer hight;
    private String emailAddress;


    private String userID;

    public UserInfo(String nickName, String avatarUrl) {
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
    }

    /*
     * OneToOne
     * JoinColumn用来指定生成的外键名字
     */
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userId")
    public User getWife() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

}
