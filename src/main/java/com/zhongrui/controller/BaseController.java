package com.zhongrui.controller;

import org.springframework.ui.Model;

/**
 * @Auther: Joanne
 * @Date: 2018/11/2 14:57
 * @Description:
 */
public class BaseController {
    Model model ;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
