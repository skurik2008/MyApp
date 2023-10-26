package myweb.controller;

import myweb.model.User;
import myweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class UserActions {

    @Autowired
    private final UserService userService;

    public UserActions(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String MainPage(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "main";
    }

    @GetMapping("/new_user")
    public String newUserForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("flag", "new");
        return "new_and_edit_user_form";
    }

    @PostMapping("/user_save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit_user")
    public String editeUser(@RequestParam Long id, Model model) {
        model.addAttribute("flag", "edit");
        model.addAttribute("user", userService.getUser(id));
        return "new_and_edit_user_form";
    }

    @GetMapping("/delete")
    public String delUser(@RequestParam long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
