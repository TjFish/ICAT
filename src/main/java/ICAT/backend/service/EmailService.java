package ICAT.backend.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendReisterEmail(String toEmailAdress,String verifyCode);
    void senChangPWDEmali(String toEmailAdress,String verifyCode);
}
