package ICAT.backend.controller;

import ICAT.backend.pojo.Admin;
import ICAT.backend.pojo.User;
import ICAT.backend.service.AdminService;
import ICAT.backend.utils.JWTUtil;
import ICAT.common.exception.UnauthorizedException;
import lombok.Data;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/Admins", produces = "application/json;charset=utf-8")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping(value = "/")
    @RequiresAuthentication
    @RequiresRoles("admin0")
    public List<AdminWithoutPassword> getAllAdmin() {
        return adminService.getAllAdmin()
                .stream()
                .map(admin -> getAdminWithoutPassword(admin))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/Password")
    @RequiresAuthentication
    @RequiresRoles("admin0")
    public String getPasswordById(@RequestParam String id) {
        return adminService.getPassword(id);
    }

    @PostMapping(value = "/")
    @RequiresAuthentication
    @RequiresRoles("admin0")
    public AdminWithoutPassword addAdmin(@RequestBody Admin admin) {
        adminService.addAdmin(admin);
        Admin newAdmin = adminService.getAdminById(admin.getAdminId()).orElse(null);
        return getAdminWithoutPassword(newAdmin);
    }

    @Data
    public static class LoginBody {
        LoginBody() {}
        private String account;
        private String password;
    }

    @PostMapping(value = "/Login")
    public ResponseEntity<String> login(@RequestBody LoginBody loginBody) {
        String account = loginBody.getAccount();
        String password = loginBody.getPassword();
        if (adminService.login(account, password) == null) {
            throw new UnauthorizedException("username or password incorrect");
        } else {
            return new ResponseEntity<>(JWTUtil.sign(account, password, "admin"), HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/{adminId}")
    @RequiresAuthentication
    @RequiresRoles("admin0")
    public AdminWithoutPassword deleteUser(@PathVariable("adminId") String id) {
        Admin admin = adminService.getAdminById(id).orElse(null);
        adminService.deleteAdmin(id);
        return getAdminWithoutPassword(admin);
    }

    @PutMapping(value = "/")
    @RequiresAuthentication
    @RequiresRoles("admin0")
    public void updateUser(Admin user) {
        adminService.updateAdmin(user);
    }

    /**
     * ignore password
     */
    @Data
    public static class AdminWithoutPassword {
        AdminWithoutPassword() {}
        private String adminId;
        private BigInteger role;
        private String nikename;
    }

    /**
     * delete password
     */
    public AdminWithoutPassword getAdminWithoutPassword(Admin admin) {
        if (admin == null) {
            return null;
        }
        AdminWithoutPassword adminWithoutPassword = new AdminWithoutPassword();
        adminWithoutPassword.adminId = admin.getAdminId();
        adminWithoutPassword.role = admin.getRole();
        adminWithoutPassword.nikename = admin.getNikename();
        return adminWithoutPassword;
    }

}
