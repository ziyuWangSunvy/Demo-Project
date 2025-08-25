package com.pokerfans.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ziyu Wang
 * @version 0.1.0
 * @since 0.1.0
 */
@RestController
@RequestMapping("/demo2")
public class Demo2Controller {

    @GetMapping
    public String demo2() {
        return "demo2";
    }
}
