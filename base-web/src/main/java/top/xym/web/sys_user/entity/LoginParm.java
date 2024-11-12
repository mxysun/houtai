package top.xym.web.sys_user.entity;

import lombok.Data;

// 封装登录参数
@Data
public class LoginParm {
    private String username;
    private String password;
    private String code;
}
