package com.zhongrui.shiro;

import com.zhongrui.entity.Userinfo;
import com.zhongrui.service.UserinfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: Joanne
 * @Date: 2018/11/5 09:31
 * @Description:
 */
public class ShiroRealm extends AuthorizingRealm {

    private static final String ALGORITHM = "MD5";

    @Autowired
    private UserinfoService userinfoService ;


    /**
     * @Author Joaane
     * @Description 授权
     * @Date 9:35 2018/11/5
     * @Param 
     * @return 
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * @Author Joaane
     * @Description 身份认证
     * @Date 9:35 2018/11/5
     * @Param 
     * @return 
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取账号密码
        UsernamePasswordToken t = (UsernamePasswordToken) token;
        String userName= token.getPrincipal().toString();
        //获取数据库中的密码
        Userinfo user = userinfoService.selectUserByUsername(userName);
        String passwordInDB = user.getPw();
        //认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :databaseRealm
        //盐也放进去
        //这样通过applicationContext-shiro.xml里配置的 HashedCredentialsMatcher 进行自动校验
        SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(userName,passwordInDB,getName());
        return a;
    }
}
