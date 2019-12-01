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
    public Optional<User> getVerifyCode(@RequestParam String id, @RequestParam Integer option) {
        return userService.getUserById(id);
    }

    @PostMapping(value = "/ChangePassword")
    public Optional<User> changePassword(@RequestParam String account, @RequestParam String password) {
        userService.changePassword(account, password);
        return userService.getUserById(account);
    }

    @PostMapping(value = "/")
    public Optional<User> addUser(@RequestBody User user) {
        userService.addUser(user);
        return userService.getUserById(user.getUserAccount());
    }

    @PostMapping(value = "/Login")
    public void login(@RequestParam String account, @RequestParam String password) {
        userService.login(account, password);
    }

    @DeleteMapping(value = "/{userId}")
    public Optional<User> deleteUser(@PathVariable("userId") String id) {
        Optional<User> user = userService.getUserById(id);
        userService.deleteUserById(id);
        return user;
    }

    @PutMapping(value = "/")
    public void updateUser(User user) {
        userService.updateUser(user);
    }

}
