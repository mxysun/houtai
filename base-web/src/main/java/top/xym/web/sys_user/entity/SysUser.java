package top.xym.web.sys_user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("sys_user")
public class SysUser {
    @TableId(type = IdType.AUTO)
    private Long userId;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String gender;
    private String isAdmin;
    //帐户是否过期(1 未过期，0已过期)
    private boolean isAccountNonExpired;
    //帐户是否被锁定(1 未锁定，0已锁定)
    private boolean isAccountNonLocked;
    //密码是否过期(1 未过期，0已过期)
    private boolean isCredentialsNonExpired;
    //帐户是否可⽤(1 可⽤，0 不可⽤)
    private boolean isEnabled;
    private String nickName;
    private Integer deleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    // 不属于用户表的字段，需要排除
    @TableField(exist = false)
    private String roleId;
}
