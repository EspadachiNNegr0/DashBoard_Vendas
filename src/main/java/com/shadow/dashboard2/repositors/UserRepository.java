package com.shadow.dashboard2.repositors;

import com.shadow.dashboard2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);  // Método que busca o usuário pelo nome de usuário
}
