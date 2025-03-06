package com.kksc.instaclone.controller.api;

import com.kksc.instaclone.config.auth.PrincipalDetails;
import com.kksc.instaclone.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class FollowApiController {

    private final FollowService followService;

    @PostMapping("/follow/{toUserId}")
    public ResponseEntity<?> followUser(@PathVariable long toUserId, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        followService.follow(principalDetails.getUser().getId(), toUserId);
        return new ResponseEntity<>("팔로우 성공", HttpStatus.OK);
    }

    @DeleteMapping("/follow/{toUserId}")
    public ResponseEntity<?> unFollowUser(@PathVariable long toUserId, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        followService.unFollow(principalDetails.getUser().getId(), toUserId);
        return new ResponseEntity<>("팔로우 취소 성공", HttpStatus.OK);
    }
}