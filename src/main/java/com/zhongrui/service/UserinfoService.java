package com.zhongrui.service;

import com.zhongrui.entity.Userinfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Auther: Joanne
 * @Date: 2018/11/2 09:36
 * @Description:
 */
public interface UserinfoService {
    
    int insert(Userinfo record);

    ArrayList<Userinfo> selectSelective(Userinfo record);

    Userinfo selectUserByUsername(String username);
}
