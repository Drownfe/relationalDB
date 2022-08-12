package com.sofkaU.relationalDB.service;

import com.sofkaU.relationalDB.dto.PostDTO;
import com.sofkaU.relationalDB.entity.Post;

public interface PostService {
    PostDTO createPost (PostDTO postDTO);
    PostDTO editPost (PostDTO postDTO);
    void deletePost (Post post);
}
