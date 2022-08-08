package com.sofkaU.relationalDB.controller;

import com.sofkaU.relationalDB.entity.Comment;
import com.sofkaU.relationalDB.entity.Post;
import com.sofkaU.relationalDB.entity.User;
import com.sofkaU.relationalDB.service.PostService;
import com.sofkaU.relationalDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin("*")
public class PostController {
    @Autowired
    private PostService service;

    @Autowired
    private UserService userService;

    @GetMapping("get/users")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }
    @GetMapping("get/comments")
    public List<Comment> getAllComments(){
        return service.findAllComments();
    }
    @GetMapping("get/posts")
    public List<Post> getAllPosts(){
        return service.findAllPost();
    }

    @PostMapping("create/post")
    public Post createPost(@RequestBody Post post){
        return service.createPost(post);
    }

    @PostMapping("create/comment")
    public Post createComment(@RequestBody Comment comment){
        return service.createComment(comment);
    }

    @PostMapping("create/user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping("delete/user")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }
    @DeleteMapping("delete/post")
    public void deletePost(@RequestBody Post post) {
        service.deletePost(post);
    }

    @DeleteMapping("delete/comment")
    public void deleteComment(@RequestBody Comment comment){
        service.deleteComment(comment);
    }

    @PutMapping("update/post")
    public void updatePost(@RequestBody Post post){
        service.updatePost(post);
    }


    @PutMapping("update/comment")
    public void updateComment(@RequestBody Comment comment){
        service.updateComment(comment);
    }
}
