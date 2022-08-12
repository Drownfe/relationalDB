package com.sofkaU.relationalDB.service;

import com.sofkaU.relationalDB.entity.UserLike;


public interface UserLikeService {
    UserLike giveLike (UserLike userLike);
    void  deleteLike (Integer id);
}
