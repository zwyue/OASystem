package com.zhongrui.service.impl;

import com.zhongrui.dao.UserInfoMapper;
import com.zhongrui.entity.UserInfo;
import com.zhongrui.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Joanne
 * @date 2018/11/2 09:39
 */
@Service
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    private UserInfoMapper userInfoMapper ;

    @Override
    public int insert(UserInfo record) {
//        return userInfoMapper.insert(record);
        return 0 ;
    }

    @Override
    public ArrayList<UserInfo> selectSelective(UserInfo record) {
//        return userinfoMapper.selectSelective(record);
//        ArrayList arrayList = userinfoMapper.selectSelective(record);
//        return arrayList ;
        return null ;
    }

    @Override
    public UserInfo selectUserByUsername(String username) {
//        return userinfoMapper.selectUserByUsername(username);
        return null ;
    }
}
