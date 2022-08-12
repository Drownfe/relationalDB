package com.sofkaU.relationalDB.service;


import com.sofkaU.relationalDB.entity.UserLike;
import com.sofkaU.relationalDB.repository.UserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserLikeServiceImplementation implements UserLikeService{
    @Autowired
    private UserLikeRepository userLikeRepository;

    @Override
    public UserLike giveLike(UserLike userLike) {
        Objects.requireNonNull(userLike);
        return userLikeRepository.save(userLike);
    }

    @Override
    public void deleteLike(Integer id) {
        userLikeRepository.deleteById(id);
    }
}
