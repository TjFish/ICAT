package ICAT.backend.controller;

import ICAT.backend.pojo.User;
import ICAT.backend.service.UserService;
import ICAT.backend.utils.JWTUtil;
import ICAT.common.exception.UnauthorizedException;
import lombok.Data;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/Users", produces = "application/json;charset=utf-8")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    @RequiresAuthentication
    @RequiresRoles("admin")
    public List<UserWithoutPassword> getAllUser() {
        return userService.getAllUser()
                .stream()
                .map(u -> getUserWithoutPassword(u))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{userId}")
    @RequiresAuthentication
    public UserWithoutPassword getUserById(@PathVariable("userId") String id) {
        User user = userService.getUserById(id).orElse(null);
        return getUserWithoutPassword(user);
    }

    @GetMapping(value = "/VerifyCode")
    public UserWithoutPassword getVerifyCode(@RequestParam String id, @RequestParam Integer option) {
        User user = userService.getUserById(id).orElse(null);
        return getUserWithoutPassword(user);
    }

    @PostMapping(value = "/ChangePassword")
    @RequiresAuthentication
    public UserWithoutPassword changePassword(@RequestParam String account, @RequestParam String password) {
        userService.changePassword(account, password);
        User user = userService.getUserById(account).orElse(null);
        return getUserWithoutPassword(user);
    }

    @PostMapping(value = "/")
    public UserWithoutPassword addUser(@RequestBody User user) {
        userService.addUser(user);
        User newUser = userService.getUserById(user.getUserAccount()).orElse(null);
        return getUserWithoutPassword(newUser);
    }

    @Data
    public static class LoginBody {
        LoginBody() {}
        private String account;
        private String password;
    }

    @PostMapping(value = "/Login")
    public ResponseEntity<String> login(@RequestBody LoginBody loginBody) {
        String account = loginBody.account;
        String password = loginBody.password;
        if (userService.login(account, password) == null) {
            throw new UnauthorizedException("username or password incorrect");
        } else {
            return new ResponseEntity<>(JWTUtil.sign(account, password, "user"), HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/{userId}")
    @RequiresAuthentication
    @RequiresRoles("admin")
    public UserWithoutPassword deleteUser(@PathVariable("userId") String id) {
        User user = userService.getUserById(id).orElse(null);
        userService.deleteUserById(id);
        return getUserWithoutPassword(user);
    }

    @PutMapping(value = "/")
    @RequiresAuthentication
    public void updateUser(User user) {
        userService.updateUser(user);
    }

    /**
     * ignore password
     */
    @Data
    public static class UserWithoutPassword {
        UserWithoutPassword() {}
        public String userAccount;
        public String nickname;
        public String introduction;
    }

    /**
     * delete password
     */
    public UserWithoutPassword getUserWithoutPassword(User user) {
        if (user == null) {
            return null;
        }
        UserWithoutPassword userWithoutPassword = new UserWithoutPassword();
        userWithoutPassword.userAccount = user.getUserAccount();
        userWithoutPassword.nickname = user.getNickname();
        userWithoutPassword.introduction = user.getIntroduction();
        return userWithoutPassword;
    }

}

