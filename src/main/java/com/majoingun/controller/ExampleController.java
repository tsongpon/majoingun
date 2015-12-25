package com.majoingun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExampleController {

    @RequestMapping(value = "/api/majoingun/hello", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/api/majoingun/register", method = RequestMethod.GET)
    public String register(){
        return "register";
    }
}
