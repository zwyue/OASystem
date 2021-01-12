package com.zhongrui.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zwy
 * @date 1/12/2021 2:26 PM
 */
@Data
public class UserInfo {
    private Integer id;

    private String sex;

    private String name;

    private String password;

    private Date createTime;
}