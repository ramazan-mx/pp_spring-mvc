package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(@RequestParam(value = "id", required = false) Integer id,
                           Model model) {
        if (id != null) {
            model.addAttribute("user", userService.getUserById(id));
            return "user-id";
        } else {
            model.addAttribute("users", userService.getAll());
            return "users";
        }
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        return "user-new";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam(value = "id", required = false) Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @PostMapping
    public String create(@RequestParam("firstname") String firstname,
                         @RequestParam("lastname") String lastname,
                         @RequestParam("email") String email) {
        userService.add(new User(firstname, lastname, email));
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id == null) {
            return "redirect:/users";
        }
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-edit";
    }

    @PostMapping("/edit")
    public String editUser(@RequestParam("firstname") String firstname,
                           @RequestParam("lastname") String lastname,
                           @RequestParam("email") String email,
                           @RequestParam("id") Integer id) {
        userService.update(id, new User(firstname, lastname, email));
        return "redirect:/users";
    }
}
