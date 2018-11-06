package com.zhongrui.dao;

import com.zhongrui.entity.Userinfo;
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
    private UserinfoMapper userinfoMapper;

    @Before
    public void setUp() throws Exception {
        // 加载spring配置文件
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        // 导入需要测试的
        userinfoMapper = applicationContext.getBean(UserinfoMapper.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectSelective() {
        Userinfo user = new Userinfo();
        user.setName("zwy");
        user.setPw(Encryption.MD5("123456"));
        List<Userinfo> userinfos = userinfoMapper.selectSelective(user);
        System.out.printf("success");
    }
}