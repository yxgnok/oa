package com.kong.oa.controller;

import com.kong.oa.biz.GlobalBiz;
import com.kong.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller("globalController")
public class GlobalController {

    @Autowired
    private GlobalBiz globalBiz;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam String sn, @RequestParam String password){
        Employee employee = globalBiz.login(sn,password);
        //登录失败，返回登录界面
        if (employee == null) {
            return "redirect:to_login";
        }
        //要使用session，直接在参数表中声明，spring会自动注入
        session.setAttribute("employee",employee);
        //登录成功，重定向到个人信息页面
        return "redirect:self";
    }

    @RequestMapping("/self")
    public String self(){
        return "self";
    }

    @RequestMapping("/quit")
    public String quit(HttpSession session) {
        session.setAttribute("employee",null);
        return "redirect:to_login";
    }

    @RequestMapping("/to_change_password")
    public String toChangePassword() {
        return "change_password";
    }

    @RequestMapping("/change_password")
    public String changePassword(HttpSession session, @RequestParam String old, @RequestParam String new1,@RequestParam String new2) {
        Employee employee = (Employee) session.getAttribute("employee");
        if (employee.getPassword().equals(old)) {
            if (new1.equals(new2) && new1 != old) {
                employee.setPassword(new1);
                globalBiz.changePassword(employee);
                return "redirect:self";
            }
        }
        return "redirect:to_change_password";
    }
}
