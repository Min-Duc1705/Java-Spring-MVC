package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.services.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
       
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.handldeHello();
        model.addAttribute("eric", test);
        model.addAttribute("hoidanit", "from controller");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        String test = this.userService.handldeHello();
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value="/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model,@ModelAttribute("newUser") User createUser) {
        this.userService.handleCreateUser(createUser);
        return "hello";
    }
}

