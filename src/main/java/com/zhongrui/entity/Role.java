package com.zhongrui.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zwy
 * @date 1/12/2021 2:25 PM
 */
@Data
public class Role {

    private Integer id;

    private String roleName;

    private Date createTime;

    private Date updateTime;
}