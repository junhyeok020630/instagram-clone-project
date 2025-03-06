package com.kksc.instaclone.dto.follow;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigInteger;

@Builder
@AllArgsConstructor
@Getter
@Data
public class FollowDto {

    private long id;
    private String name;
    private String profileImgUrl;
    private int followState;
    private int loginUser;

    public FollowDto(BigInteger id, String name, String profileImgUrl, int followState, int loginUser) {
        this.id = id.longValue();
        this.name = name;
        this.profileImgUrl = profileImgUrl;
        this.followState = followState;
        this.loginUser = loginUser;
    }
}
