package com.kksc.instaclone.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentUploadDto {
    @NotBlank
    private String text;

    @NotNull
    private Long postId;
}
