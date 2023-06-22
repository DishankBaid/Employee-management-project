package Dishank.Project01.Controller;

import Dishank.Project01.DTO.UserDto;
import Dishank.Project01.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    public UserService userService;

    @PostMapping("/login")
    public String Login(@RequestParam("username")String email,@RequestParam("password")String password){
        return "redirect:/home";
    }

}
