package com.zhongrui.dao;

import com.zhongrui.entity.UserInfo;

import java.util.ArrayList;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    ArrayList<UserInfo> selectSelective(UserInfo record);

    UserInfo selectUserByUsername(String username);
}