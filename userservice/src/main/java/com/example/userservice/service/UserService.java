package com.example.userservice.service;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;

import java.util.Optional;

public interface UserService {

    UserRepository getRepository();

    default UserDTO getUserByUsername(String username) {
        Optional<User> user = getRepository().findByUsername(username);
        return user.map(u -> new UserDTO(u.getId(), u.getUsername(), u.getEmail()))
                   .orElse(null);
    }

    default User saveUser(User user) {
        return getRepository().save(user);
    }
}
