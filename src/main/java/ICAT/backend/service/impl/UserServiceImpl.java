package ICAT.backend.service.impl;

import ICAT.backend.pojo.User;
import ICAT.backend.dao.repository.UserRepository;
import ICAT.backend.service.EmailService;
import ICAT.backend.service.UserService;
import ICAT.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Transactional
@Service
@CacheConfig(cacheNames = "User")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;

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

    @Override
    public String getVerifyCode(String id,Integer option) {
        Optional<User> user = userRepository.findById(id);
        Integer randomNum=new Random().nextInt(999999 - 100000 + 1) + 100000;
        String verifyCode= randomNum.toString();
        if(option==1){
            if(user.isPresent()) {// 注册请求但该账户已经注册
                throw new ServiceException("用户已注册", HttpStatus.CONFLICT);
            }
            emailService.sendReisterEmail(id,verifyCode);
            return verifyCode;
        }
        if(option==2){
            if(!user.isPresent()) {//修改密码请求但该账户未注册
                throw  new ServiceException("用户未注册",HttpStatus.NOT_FOUND);
            }
            emailService.senChangPWDEmali(id,verifyCode);
            return verifyCode;
        }
        //option != 1 and option ！= 2
        throw new ServiceException("不支持的操作",HttpStatus.BAD_REQUEST);
    }




}
