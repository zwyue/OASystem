package com.zhongrui.shiro;

import com.zhongrui.entity.UserInfo;
import com.zhongrui.service.UserinfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : Joanne
 * @date : 2018/11/5 09:31
 */
public class ShiroRealm extends AuthorizingRealm {

//    private static final String ALGORITHM = "MD5";

    @Autowired
    private UserinfoService userinfoService ;


    /**
     * 授权
     *
     * @author Joanne
     * @date 9:35 2018/11/5
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 身份认证
     *
     * @author Joanne
     * @date 9:35 2018/11/5
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取账号密码
//        UsernamePasswordToken t = (UsernamePasswordToken) token;
        String userName= token.getPrincipal().toString();
        //获取数据库中的密码
        UserInfo user = userinfoService.selectUserByUsername(userName);
        String passwordInDataBase = user.getPassword();
        //认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :databaseRealm
        //盐也放进去
        //这样通过applicationContext-shiro.xml里配置的 HashedCredentialsMatcher 进行自动校验
        return new SimpleAuthenticationInfo(userName,passwordInDataBase,getName());
    }
}
