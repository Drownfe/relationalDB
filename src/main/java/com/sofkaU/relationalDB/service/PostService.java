package com.sofkaU.relationalDB.service;

import com.sofkaU.relationalDB.entity.Comment;
import com.sofkaU.relationalDB.entity.Post;
import java.util.List;

public interface PostService {
    Post createPost(Post post);
    Post createComment(Comment comment);

    void updatePost(Post post);
    void updateComment(Comment comment);
    void deleteComment(Comment comment);
    void deletePost(Post post);

    List<Post> findAllPost();

    List<Comment> findAllComments();
}
