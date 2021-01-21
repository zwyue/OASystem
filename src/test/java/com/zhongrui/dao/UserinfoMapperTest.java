package com.zhongrui.dao;

import com.zhongrui.entity.UserInfo;
import com.zhongrui.util.Encryption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserinfoMapperTest {

    private ApplicationContext applicationContext;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Before
    public void setUp() throws Exception {
        // 加载spring配置文件
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        // 导入需要测试的
        userInfoMapper = applicationContext.getBean(UserInfoMapper.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectSelective() {
        UserInfo user = new UserInfo();
        user.setName("zwy");
        user.setPassword(Encryption.md5("123456"));
//        List<UserInfo> userinfos = userInfoMapper.selectSelective(user);
//        System.out.printf("success");
    }
}