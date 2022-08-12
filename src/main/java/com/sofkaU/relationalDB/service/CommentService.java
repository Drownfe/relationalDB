package com.sofkaU.relationalDB.service;


import com.sofkaU.relationalDB.dto.CommentDTO;
import com.sofkaU.relationalDB.entity.Comment;

public interface CommentService {
    CommentDTO createComment (CommentDTO commentDTO);

    CommentDTO editComment (CommentDTO commentDTO);
    void deleteComment (Comment comment);
}
