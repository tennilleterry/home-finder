package com.project.homefinder.controllers;

import com.project.homefinder.models.User;
import com.project.homefinder.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "user")
public class LoginController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String displayUserLoginForm(Model model){
        model.addAttribute("title", "Login");
        model.addAttribute("previousUsername", "");
        return "user/login";
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String processUserLoginForm(Model model,
                                       String userName,
                                       String password){
        if(userDao.existsByName(userName)){
            User logIn = userDao.findByName(userName);
            if(password.equals(logIn.getPassword())){

                return "redirect:/property/add";
                //return "redirect:/property/index";
                //return "redirect:/user/index";
            } else {
                model.addAttribute("title", "Login");
                model.addAttribute("previousUsername", userName);
                model.addAttribute("passwordError", "Incorrect password");
                return "user/login";
            }
        } else {
            model.addAttribute("title", "Login");
            model.addAttribute("usernameError", "That user does not exist.");
            return "user/login";
        }
    }


    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String displayLogoutForm(Model model) {
        model.addAttribute("title", "LOGOUT");
        return "user/logout";
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public String processLogoutForm(Model model) {

        return "redirect:";
    }

}