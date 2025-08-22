package com.pokerfans.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ziyu Wang
 * @version 0.1.0
 * @since 0.1.0
 */
@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        int a = 1 + 1;
        return "hello world";
    }

    @RequestMapping("/hello1")
    public String hello1() {
        int a = 1 + 1;
        return "hello world";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "hello world";
    }
}
