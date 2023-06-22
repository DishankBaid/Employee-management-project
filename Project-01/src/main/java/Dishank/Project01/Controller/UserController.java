package Dishank.Project01.Controller;

import Dishank.Project01.DTO.UserDto;
import Dishank.Project01.Repository.UserRepository;
import Dishank.Project01.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import Dishank.Project01.Entity.User;
@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/registration")
    public String saveUser(@RequestBody UserDto userDto){
        userService.saveNewUser(userDto);
        return "Successfully saved the user";
    }
}
