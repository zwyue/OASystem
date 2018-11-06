package com.zhongrui.service.impl;

import com.zhongrui.dao.UserinfoMapper;
import com.zhongrui.entity.Userinfo;
import com.zhongrui.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Auther: Joanne
 * @Date: 2018/11/2 09:39
 * @Description:
 */
@Service
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper ;

    @Override
    public int insert(Userinfo record) {
        return userinfoMapper.insert(record);
    }

    @Override
    public ArrayList<Userinfo> selectSelective(Userinfo record) {
        return userinfoMapper.selectSelective(record);
//        ArrayList arrayList = userinfoMapper.selectSelective(record);
//        return arrayList ;
    }

    @Override
    public Userinfo selectUserByUsername(String username) {
        return userinfoMapper.selectUserByUsername(username);
    }
}
