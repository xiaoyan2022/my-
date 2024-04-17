package com.Gcms.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc :
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;             //用户名
    private String password;            //用户密码
    private String name;                //用户昵称
    private String communityName;       //小区名
    private String email;               //邮箱
    private String phone;               //联系电话
    private Integer status;             //状态（0表示正常，1表示异常）
    private Date createTime;            //创建时间
}
