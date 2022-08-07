package com.sofkaU.relationalDB.service;

import com.sofkaU.relationalDB.entity.User;
import com.sofkaU.relationalDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.deleteById(user.getId());
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
