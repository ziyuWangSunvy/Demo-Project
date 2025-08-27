package com.pokerfans.controller;

import com.pokerfans.entity.User;
import com.pokerfans.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ziyu Wang
 * @version 0.1.0
 * @since 0.1.0
 */
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("{id}")
    public String getUserById(@PathVariable Long id, Model uiModel) {
        User user = userService.getUserById(id);
        uiModel.addAttribute("user", user);
        return "index";
    }

    @PostMapping("/save")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
