package com.drww.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * className:allJump
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-21 20:24
 */
@Controller
@RequestMapping(value = "jump")
public class AllJumpController {

    @RequestMapping(value = ("toProductList"))
        public String toProductList(){

         return "productList";
        }

    @RequestMapping(value = ("toUserList"))
    public String toUserList(){

        return "userList";
    }



}
