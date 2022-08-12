package com.sofkaU.relationalDB.service;

import com.sofkaU.relationalDB.dto.PostDTO;
import com.sofkaU.relationalDB.entity.Post;
import com.sofkaU.relationalDB.mappers.PostMapper;
import com.sofkaU.relationalDB.repository.CommentRepository;
import com.sofkaU.relationalDB.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImplementation implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostMapper postMapper;

    @Autowired
    private UserLikeService userLikeService;

    @Autowired
    private CommentService commentService;

    public List<PostDTO> getAllPost(){
        return postRepository.findAll()
                .stream()
                .map(postMapper::convertPostToDto)
                .collect(Collectors.toList());
    }
    @Override
    public PostDTO createPost(PostDTO postDTO){
        System.out.println(postDTO);
        Post post = postMapper.dtoMapper(postDTO);
                return postMapper.convertPostToDto(postRepository.save(post));
    }
    @Override
    public PostDTO editPost(PostDTO postDTO){
        var targetPost = postRepository.findById(postDTO.getId());
        if(targetPost.isPresent()){
            var postEdited = postRepository.save(postMapper.dtoMapper(postDTO));
            var postEditedDTO = postMapper.convertPostToDto(postEdited);
            return postEditedDTO;
        }
        throw new IllegalStateException("We couldn't find the post");
    }
    @Override
    public void deletePost(Post post){
       Post postToBeDeleted = postRepository.findById(post.getId()).get();
       if (postToBeDeleted.getComments().size()>=0){
           postToBeDeleted.getComments().forEach(comment -> commentRepository.deleteById(comment.getId()));
       }
       postRepository.deleteById(post.getId());
    }
}
