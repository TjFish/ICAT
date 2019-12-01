package backend.service.impl;

import backend.dao.repository.AdminRepository;
import backend.pojo.Admin;
import backend.service.AdminService;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@CacheConfig(cacheNames = "Admin")
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    @CachePut(key = "#admin.adminId")
    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public Optional<Admin> getAdminById(String id) {
        return adminRepository.findById(id);
    }

    @Override
    @CachePut(key = "#admin.adminId")
    public void updateAdmin(Admin admin) {
        adminRepository.saveAndFlush(admin);
    }

    @Override
    @CacheEvict(key = "#p0")
    public void deleteAdmin(String id) {
        adminRepository.deleteById(id);
    }

    @Override
    public String getPassword(String id) {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin == null) {
            return null;
        } else {
            return admin.getPassword();
        }
    }

    @Override
    public Admin login(String id, String password) {
        return adminRepository.getAdminByAdminIdAndPassword(id, password);
    }

}
