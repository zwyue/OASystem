package com.zhongrui.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zwy
 * @date 1/12/2021 2:26 PM
 */
@Data
public class UserPermission {

    private Integer id;

    private Integer operationId;

    private String url;

    private Date createTime;

    private Date updateTime;
}