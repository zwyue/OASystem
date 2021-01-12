package com.zhongrui.service;

import com.zhongrui.entity.UserInfo;

import java.util.ArrayList;

/**
 * @author Joanne
 * @date  2018/11/2 09:36
 */
public interface UserinfoService {
    
    int insert(UserInfo record);

    ArrayList<UserInfo> selectSelective(UserInfo record);

    UserInfo selectUserByUsername(String username);
}
