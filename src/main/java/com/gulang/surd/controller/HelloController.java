package com.gulang.surd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: gulang
 * Create Date : 2017/7/25
 * Company     : Garden Plus
 * Description :
 */
@Controller
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        return "index";
    }
}
