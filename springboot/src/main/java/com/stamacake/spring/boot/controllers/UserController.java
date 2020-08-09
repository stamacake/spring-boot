package com.stamacake.spring.boot.controllers;

import com.stamacake.spring.boot.Services.UserService;
import com.stamacake.spring.boot.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/all")
    public String getAllUsers(Model model, @RequestParam(required = false) Integer maxAge) {
        model.addAttribute("users", userService.getUserWithMaxAgeFiltering(maxAge));
        return "allusers";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users/all";
    }

    @GetMapping("/find")
    @ResponseBody
    public User findUser(@RequestParam long id) {
        return userService.find(id);
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.delete(id);
        return "redirect:/users/all";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.find(id));
        return "edituser";
    }
}
