package com.shadow.dashboard2.services;


import com.shadow.dashboard2.models.User;
import com.shadow.dashboard2.repositors.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Método de autenticação (exemplo simples)
    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true; // Autenticação bem-sucedida
        }
        return false; // Falha na autenticação
    }

    // Método que encontra um usuário pelo nome de usuário
    public User findByUsername(String username) {
        return userRepository.findByUsername(username); // Supondo que seu repositório tenha esse método
    }
}
