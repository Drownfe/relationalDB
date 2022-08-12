package com.sofkaU.relationalDB.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserLikeDTO {
    private Integer id;

    @Size(min= 10 ,max= 50, message = "Please write between 10 to 50 characters")
    private String userName;
    @Size(min= 8 ,max= 20, message = "Please write between 8 to 20 characters")
    private String dni;
    private List<CommentDTO> comments = new ArrayList<>();
    private List<PostDTO> posts = new ArrayList<>();
}
