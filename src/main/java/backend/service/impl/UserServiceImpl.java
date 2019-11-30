package backend.service.impl;

import backend.dao.repository.UserRepository;
import backend.pojo.User;
import backend.service.UserService;
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
    @Cacheable(key = "#id")
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

}
