package com.zhongrui.service.impl;

import com.zhongrui.dao.UserinfoMapper;
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
    private UserinfoMapper userinfoMapper ;

    @Override
    public int insert(UserInfo record) {
        return userinfoMapper.insert(record);
    }

    @Override
    public ArrayList<UserInfo> selectSelective(UserInfo record) {
        return userinfoMapper.selectSelective(record);
//        ArrayList arrayList = userinfoMapper.selectSelective(record);
//        return arrayList ;
    }

    @Override
    public UserInfo selectUserByUsername(String username) {
        return userinfoMapper.selectUserByUsername(username);
    }
}
