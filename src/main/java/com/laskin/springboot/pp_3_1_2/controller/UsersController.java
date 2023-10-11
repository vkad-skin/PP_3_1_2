package com.laskin.springboot.pp_3_1_2.controller;

import com.laskin.springboot.pp_3_1_2.model.User;
import com.laskin.springboot.pp_3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/show-all-users")
    public String showAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getUsers());
        return "all-users";
    }

    @GetMapping("/new-user")
    public String addNewUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "info-user";
    }

    @PostMapping("/add-or-update-user")
    public String saveOrUpdateUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/show-all-users";
    }

    @GetMapping("/get-user")
    public String getUserById(@RequestParam("userId") int id, ModelMap model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "info-user";
    }

    @DeleteMapping("/delete-user")
    public String deleteUser(@RequestParam("userId") int id) {
        userService.deleteUserById(id);
        return "redirect:/show-all-users";
    }
}
