package backend.controller;

import backend.pojo.User;
import backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping(value = "/")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable("userId") String id) {
        userService.deleteUserById(id);
    }

    @PutMapping(value = "/")
    public void updateUser(User user) {
        userService.updateUser(user);
    }

}
