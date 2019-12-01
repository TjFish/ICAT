package backend.controller;

import backend.pojo.User;
import backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Users", produces = "application/json;charset=utf-8")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping(value = "/{userId}")
    public Optional<User> getUserById(@PathVariable("userId") String id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/VerifyCode")
    public String getVerifyCode() {
        return null;
    }

    @PostMapping(value = "/ChangePassword")
    public void changePassword() {

    }

    @PostMapping(value = "/")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PostMapping(value = "/Login")
    public void login() {

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
