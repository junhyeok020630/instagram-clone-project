package com.kksc.instaclone.dto.post;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class PostDto {

    private long id;
    private String tag;
    private String text;
    private String postImgUrl;
}
