package com.sofkaU.relationalDB.service;

import com.sofkaU.relationalDB.dto.CommentDTO;
import com.sofkaU.relationalDB.entity.Comment;
import com.sofkaU.relationalDB.mappers.CommentMapper;
import com.sofkaU.relationalDB.repository.CommentRepository;
import com.sofkaU.relationalDB.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserLikeService userLikeService;

    @Override
    public CommentDTO createComment(CommentDTO commentDTO){
        return commentMapper
                .convertCommentToDto(commentRepository.save(commentMapper.commentDtoToEntity(commentDTO)));

    }
    @Override
    public CommentDTO editComment(CommentDTO commentDTO){
        var targetComment = commentRepository.findById(commentDTO.getId());
        if(targetComment.isPresent()){
            var commentEdited = commentRepository.save(commentMapper.commentDtoToEntity(commentDTO));
            var commentEditedDTO = commentMapper.convertCommentToDto(commentEdited);
            return commentEditedDTO;
        }
        throw new IllegalStateException("We couldn't find the comment");
    }
    @Override
    public void deleteComment(Comment comment){
        commentRepository.deleteById(comment.getId());
    }

}
