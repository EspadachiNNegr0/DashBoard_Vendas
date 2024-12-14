package com.shadow.dashboard2.config;

import com.shadow.dashboard2.models.User;
import com.shadow.dashboard2.repositors.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User user = new User();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("admin123"));
            // Adicionando o prefixo ROLE_ à role
            user.setRoles(new HashSet<>(Arrays.asList("ROLE_ADMIN"))); // Usando HashSet para evitar duplicatas

            userRepository.save(user);
        }
    }
}
