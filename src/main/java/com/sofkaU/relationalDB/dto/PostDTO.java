package com.sofkaU.relationalDB.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PostDTO {
    private Integer id;
    @Size(min= 5 ,max= 50, message = "Please write between 5 to 50 characters")
    private String title;

    @Size(min= 10 ,max= 255, message = "Please write between 10 to 255 characters")
    private String content;
    @Min(value= 0 ,message = "Invalid amount")
    private Integer numberOfLikes;

    private List<CommentDTO> comments = new ArrayList<>();
    private List<UserLikeDTO> userLikes = new ArrayList<>();



}