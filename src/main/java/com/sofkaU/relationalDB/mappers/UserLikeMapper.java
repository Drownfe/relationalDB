package com.sofkaU.relationalDB.mappers;

import com.sofkaU.relationalDB.dto.UserLikeDTO;
import com.sofkaU.relationalDB.entity.UserLike;
import org.springframework.stereotype.Component;

@Component
public class UserLikeMapper {

    public UserLikeDTO convertUserLikeToDto(UserLike userLike){
        UserLikeDTO userLikeDTO = new UserLikeDTO();
        userLikeDTO.setId(userLike.getId());
        userLikeDTO.setUserName(userLike.getUserName());
        userLikeDTO.setDni(userLike.getDni());
        userLikeDTO.setComments(userLikeDTO.getComments()); //REVIEW
        userLikeDTO.setPosts(userLikeDTO.getPosts()); // REVIEW
        return userLikeDTO;
    }

    public UserLike userLikeDtoMapper(UserLikeDTO userLikeDTO){
        UserLike userLike = new UserLike();
        userLike.setId(userLikeDTO.getId());
        userLike.setUserName(userLikeDTO.getUserName());
        return userLike;
    }
}
