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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UserId;

    private String UserName;

    private String UserPwd;

    private String SX;



    /*
     * OneToOne
     * JoinColumn用来指定生成的外键名字
     */
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="userId")
    public UserInfo getWife() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    private UserInfo userInfo;
}
