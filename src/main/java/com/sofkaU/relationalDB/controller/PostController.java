package com.sofkaU.relationalDB.controller;

import com.sofkaU.relationalDB.dto.CommentDTO;
import com.sofkaU.relationalDB.dto.PostDTO;
import com.sofkaU.relationalDB.entity.Comment;
import com.sofkaU.relationalDB.entity.Post;
import com.sofkaU.relationalDB.service.CommentServiceImplementation;
import com.sofkaU.relationalDB.service.PostServiceImplementation;
import com.sofkaU.relationalDB.service.UserLikeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class PostController {
    @Autowired
    private PostServiceImplementation postService;
    @Autowired
    private CommentServiceImplementation commentService;
    @Autowired
    private UserLikeServiceImplementation userLikeService;

    @GetMapping("get/all/post")

    public List<PostDTO> getAllPost(){
        return postService.getAllPost();
    }
    @PostMapping("create/post")

    public PostDTO createPost(@RequestBody PostDTO postDTO){
        return postService.createPost(postDTO);
    }
    @PostMapping("create/comment")
    public CommentDTO createComment(@RequestBody  CommentDTO commentDTO){
        return commentService.createComment(commentDTO);
    }

    @PutMapping("edit/post")
    public PostDTO editPost(@RequestBody PostDTO postDTO){
        return postService.editPost(postDTO);
    }

    @PutMapping("edit/comment")
    public CommentDTO editComment(@RequestBody CommentDTO commentDTO){
        return commentService.editComment(commentDTO);
    }

    @DeleteMapping("delete/post")
    public void deletePost(@RequestBody Post post){
        postService.deletePost(post);
    }

    @DeleteMapping("delete/comment")
    public void deleteComment(@RequestBody Comment comment){
        commentService.deleteComment(comment);
    }

}