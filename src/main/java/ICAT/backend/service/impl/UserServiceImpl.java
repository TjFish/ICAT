package ICAT.backend.service.impl;

import ICAT.backend.pojo.User;
import ICAT.backend.dao.repository.UserRepository;
import ICAT.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@CacheConfig(cacheNames = "User")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    @CachePut(key = "#user.userAccount")
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    @CacheEvict(key = "#p0")
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    @CachePut(key = "#user.userAccount")
    public void updateUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    @CachePut(key = "#id")
    public void changePassword(String id, String password) {
        userRepository.updatePasswordById(id, password);
    }

    @Override
    public User login(String id, String password) {
        return userRepository.getByUserAccountAndPassword(id, password);
    }

    @Override
    @Cacheable(key = "#id")
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

}