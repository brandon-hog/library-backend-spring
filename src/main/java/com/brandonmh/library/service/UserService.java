package com.brandonmh.library.service;

import com.brandonmh.library.model.User;
import com.brandonmh.library.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User create(User user) {
        return userRepo.save(user);
    }

    public User update(Long id, User user) {
        user.setId(id);
        return userRepo.save(user);
    }

    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }
}
