package com.zhongrui.entity;

import lombok.Data;

/**
 * @author zwy
 * @date 1/12/2021 2:25 PM
 */
@Data
public class Message {

    private Integer id;

    private String command;

    private String description;

    private String content;
}