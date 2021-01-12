package com.zhongrui.controller;

import org.springframework.ui.Model;

/**
 * @author Joanne
 * @date 2018/11/2 14:57
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
