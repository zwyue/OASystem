package com.zhongrui.dao;

import com.zhongrui.entity.Userinfo;

import java.util.ArrayList;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    ArrayList<Userinfo> selectSelective(Userinfo record);

    Userinfo selectUserByUsername(String username);
}