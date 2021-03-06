package com.endava.springsecurity.application.web.controller;

import com.endava.springsecurity.application.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public String loginForm(Model model, HttpServletRequest request){
        model.addAttribute("user",new User());
        try{
            Object flash=request.getSession().getAttribute("flash");
            model.addAttribute("flash",flash);


            request.getSession().removeAttribute("flash");

        }
        catch (Exception ex){}
        return "login";
    }


    @PreAuthorize("hasAnyRole('user')")
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String successLoginUser(Model model){
        return "todo";
    }

    @PreAuthorize("hasRole('admin')")
    @RequestMapping(path = "/admin",method = RequestMethod.GET)
    public String successLoginadmin(){
        return "admin";
    }






    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String logoutForm(Model model, HttpServletRequest request)
    {
        try{
            Object flash=request.getSession().getAttribute("flash");
            model.addAttribute("flash",flash);


            request.getSession().removeAttribute("flash");

        }
        catch (Exception ex){}
        return "login";
    }

    @RequestMapping("/access_denied")
    public String accessDenied(){return "access_denied";}

}
