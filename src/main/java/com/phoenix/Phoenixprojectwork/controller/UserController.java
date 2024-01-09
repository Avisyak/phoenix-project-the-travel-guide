package com.phoenix.Phoenixprojectwork.controller;

import com.phoenix.Phoenixprojectwork.config.CustomMessageSource;
import com.phoenix.Phoenixprojectwork.dto.AuthenticationRequest;
import com.phoenix.Phoenixprojectwork.dto.AuthenticationResponse;
import com.phoenix.Phoenixprojectwork.dto.UserDto;
import com.phoenix.Phoenixprojectwork.services.UserAuthenticationService;
import com.phoenix.Phoenixprojectwork.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class UserController extends BaseController {

    private final UserService userService;
    private final CustomMessageSource customMessageSource;
    private final UserAuthenticationService userAuthenticationService;


    public UserController(UserService userService, CustomMessageSource customMessageSource, UserAuthenticationService userAuthenticationService) {
        this.userService = userService;
        this.customMessageSource = customMessageSource;
        this.userAuthenticationService = userAuthenticationService;
    }

    @GetMapping({"/home","/"})
    public String getHome() {
        return "Home";
    }

    @GetMapping("/Login-page")
    public String getLoginPage(){
        return "UserLogin";
    }

    @PostMapping("/signup")
    public String register(@ModelAttribute UserDto userDto, Model model) {

        if (userDto.getUserName() !=null){
            model.addAttribute("userName","Username already exists");
        }

        try {
            userService.register(userDto);
            successResponse(customMessageSource.get("success.save"), customMessageSource.getNp("success.save"));
            return "redirect:/Login-page";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("processError", e.getMessage());
            return "redirect:/Login-page";
        }


    }

    @PostMapping("/login")
    public String authenticate(@ModelAttribute AuthenticationRequest authenticationRequest, Model model, HttpSession session) {
       AuthenticationResponse user =  userAuthenticationService.authenticate(authenticationRequest);
       if (user !=null){
//           session.setAttribute("activeuser", user);
           return "redirect:/home";
       }
       model.addAttribute("errorLogin","You are not authenticated");
       return "redirect:/Login-page";
    }
}
