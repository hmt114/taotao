package com.taotao.sso.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hmt
 * @date 2019/8/10 16:11
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/showLogin")
    public String showLogin(String redirect, Model model){
        model.addAttribute("redirect",redirect);
        return "login";
    }
    @RequestMapping("/showRegister")
    public String showRegister(){
        return "register";
    }
}
