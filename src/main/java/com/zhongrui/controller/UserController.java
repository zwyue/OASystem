package com.zhongrui.controller;

import com.zhongrui.entity.UserInfo;
import com.zhongrui.service.RoleService;
import com.zhongrui.service.UserinfoService;
import com.zhongrui.util.Encryption;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : Joanne
 * @date : 2018/11/2 09:43
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserinfoService userinfoService;

    @Autowired
    private RoleService roleService ;

    @Resource(name = "transactionTemplate")
    private TransactionTemplate transactionTemplate ;

    public UserController() {
    }

    /**
     * 转入注册页
     *
     * @author Joanne
     * @date 11:47 2018/11/2
     **/
    @GetMapping(value = "/register")
    public String register(){
        return "register";
    }

    /**
     * 注册
     *
     * @author Joanne
     * @date 11:47 2018/11/2
     **/
    @PostMapping(value = "register")
    public String addUser(@ModelAttribute UserInfo user, Model model){
        UserInfo record = new UserInfo();
        record.setName(user.getName());
        List<UserInfo> list = userinfoService.selectSelective(record);
        if (list.size()==0){
            user.setCreateTime(new Date());
            user.setPassword(Encryption.md5(user.getPassword()));
            if (userinfoService.insert(user)==1){
                model.addAttribute("status",0);
            }else {
                model.addAttribute("status",1);
            }
        }else {
            model.addAttribute("status",2);
        }
        return "register";
    }

    /**
     * 转入登陆页
     *
     * @author Joanne
     * @date 11:47 2018/11/2
     **/
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 登陆
     *
     * @author Joanne
     * @date 11:48 2018/11/2
     **/
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginValidate(HttpSession session, Model model, @ModelAttribute final UserInfo user) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPassword());
        List<UserInfo> list = new ArrayList<UserInfo>();
        UserInfo record  = new UserInfo();
        record.setName(user.getName());
        list = userinfoService.selectSelective(record);
        if (list.size() == 0) {
            model.addAttribute("status", 1);
        } else {
            record.setPassword(Encryption.md5(user.getPassword()));
            list = userinfoService.selectSelective(record);
            if (list.size() == 0) {
                model.addAttribute("status", 2);
            }
//            List<Role> roleList = roleService.selectRoleList(user.getId());
//            record = list.get(0);
//            final Userinfo ui = record ;
//            if(roleList.size()==0){
//                if(user.getName().equals("admin")){
//
//                    transactionTemplate.execute(new TransactionCallback<Integer>() {
//                        @Override
//                        public Integer doInTransaction(TransactionStatus status) {
//                            Role role = new Role();
//                            role.setRoleName("admin");
//                            role.setCreateTime(new Date());
//                            role.setUpdateTime(new Date());
//                            int roleId = roleService.insertRole(role);
//                            roleService.insertUserRoleRe(ui.getId(),roleId);
//                            return null;
//                        }
//                    });
//
//                }
//            }
            session.setAttribute("userinfo", record);
            model.addAttribute("status", 0);
        }
        return "login";
    }

    /**
     * 用户信息
     *
     * @author Joanne
     * @date 11:48 2018/11/2
     **/
    @RequestMapping(value="/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, HttpSession session) {
        UserInfo user = (UserInfo) session.getAttribute("userinfo");
        if(user != null){
            model.addAttribute("user", user);
        }

        return "userInfo";
    }

    /**
     * 登出
     *
     * @author Joanne
     * @date 11:48 2018/11/2
     **/
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        //session.removeAttribute("user");
        return "login";
    }
}
