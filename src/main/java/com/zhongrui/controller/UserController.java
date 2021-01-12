package com.zhongrui.controller;

import com.zhongrui.entity.Userinfo;
import com.zhongrui.service.RoleService;
import com.zhongrui.service.UserinfoService;
import com.zhongrui.util.Encryption;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : Joanne
 * @date : 2018/11/2 09:43
 */
@Controller
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
     * @Author Joaane
     * @Description  转入注册页
     * @Date 11:47 2018/11/2
     * @Param
     * @return
     **/
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    /**
     * @Author Joaane
     * @Description 注册
     * @Date 11:47 2018/11/2
     * @Param
     * @return
     **/
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String addUser(@ModelAttribute Userinfo user, Model model){
        Userinfo record = new Userinfo();
        record.setName(user.getName());
        List<Userinfo> list = userinfoService.selectSelective(record);
        if (list.size()==0){
            user.setCreatetime(new Date());
            user.setPw(Encryption.MD5(user.getPw()));
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
     * @Author Joaane
     * @Description 转入登陆页
     * @Date 11:47 2018/11/2
     * @Param
     * @return
     **/
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * @Author Joaane
     * @Description 登陆
     * @Date 11:48 2018/11/2
     * @Param
     * @return
     **/
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginValidate(HttpSession session, Model model, @ModelAttribute final Userinfo user) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPw());
        List<Userinfo> list = new ArrayList<Userinfo>();
        Userinfo record  = new Userinfo();
        record.setName(user.getName());
        list = userinfoService.selectSelective(record);
        if (list.size() == 0) {
            model.addAttribute("status", 1);
        } else {
            record.setPw(Encryption.MD5(user.getPw()));
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
     * @Author Joaane
     * @Description 用户信息
     * @Date 11:48 2018/11/2
     * @Param
     * @return
     **/
    @RequestMapping(value="/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, HttpSession session) {
        Userinfo user = (Userinfo) session.getAttribute("userinfo");
        if(user != null){
            model.addAttribute("user", user);
        }

        return "userInfo";
    }

    /**
     * @Author Joaane
     * @Description 登出
     * @Date 11:48 2018/11/2
     * @Param
     * @return
     **/
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        //session.removeAttribute("user");
        return "login";
    }
}
