package com.example.userregister.controller;

import com.example.userregister.mernis.OBKKPSPublicSoap;
import com.example.userregister.model.User;
import com.example.userregister.repository.UserRepository;
import com.example.userregister.service.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UsersController {
    private final UserRepository userRepository;
    private RabbitMQProducer rabbitMQProducer;

    @Autowired
    public UsersController(UserRepository userRepository, RabbitMQProducer rabbitMQProducer) {
        this.userRepository = userRepository;
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @PostMapping("")
    public ResponseEntity<String> register(@RequestBody User user) throws Exception {
        OBKKPSPublicSoap client=new OBKKPSPublicSoap();
        boolean isRealPerson=client.TCKimlikNoDogrula(Long.valueOf(user.getIdentityNumber()),user.getFirstName(),user.getLastName(),user.getBirthOfDateYear());
        if (!isRealPerson){
            userRepository.save(user);
            rabbitMQProducer.sendMailAddressToQueue(user.getEmail());
            return ResponseEntity.ok("Kullanıcı başarı ile kayıt edildi");
        }
        return ResponseEntity.badRequest().body("Yanlış kullanıcı bilgileri");
    }

}
