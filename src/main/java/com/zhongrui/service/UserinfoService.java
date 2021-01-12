package com.zhongrui.service;

import com.zhongrui.entity.Userinfo;

import java.util.ArrayList;

/**
 * @author Joanne
 * @date  2018/11/2 09:36
 */
public interface UserinfoService {
    
    int insert(Userinfo record);

    ArrayList<Userinfo> selectSelective(Userinfo record);

    Userinfo selectUserByUsername(String username);
}
