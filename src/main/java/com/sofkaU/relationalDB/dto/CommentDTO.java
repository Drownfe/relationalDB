package com.sofkaU.relationalDB.dto;

import com.sofkaU.relationalDB.entity.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CommentDTO {
    private Integer id;

    @Size(min= 10 ,max= 255, message = "Please write between 10 to 255 characters")
    private String content;

    @Min(value= 0 ,message = "Invalid amount")
    private String numberOfLikes;

    private Post postIdPost;
    private List<UserLikeDTO> userLikes = new ArrayList<>();
}