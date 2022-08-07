package com.sofkaU.relationalDB.service;

import com.sofkaU.relationalDB.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    void deleteUser(User user);
    List<User> findAllUsers();
}
