package backend.controller;

import backend.pojo.Admin;
import backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Admins", produces = "application/json;charset=utf-8")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping(value = "/")
    public List<Admin> getAllAdmin() {
        return adminService.getAllAdmin();
    }

    @GetMapping(value = "/Password")
    public String getPasswordById(@RequestParam String id) {
        return adminService.getPassword(id);
    }

    @PostMapping(value = "/")
    public Optional<Admin> addAdmin(@RequestBody Admin admin) {
        adminService.addAdmin(admin);
        return adminService.getAdminById(admin.getAdminId());
    }

    @PostMapping(value = "/Login")
    public void login(@RequestParam String account, @RequestParam String password) {
        adminService.login(account, password);
    }

    @DeleteMapping(value = "/{adminId}")
    public Optional<Admin> deleteUser(@PathVariable("adminId") String id) {
        Optional<Admin> user = adminService.getAdminById(id);
        adminService.deleteAdmin(id);
        return user;
    }

    @PutMapping(value = "/")
    public void updateUser(Admin user) {
        adminService.updateAdmin(user);
    }

}
