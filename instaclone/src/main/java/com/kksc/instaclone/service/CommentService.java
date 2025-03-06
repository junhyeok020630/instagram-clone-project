package com.kksc.instaclone.service;

import com.kksc.instaclone.entity.Comment;
import com.kksc.instaclone.entity.Post;
import com.kksc.instaclone.entity.User;
import com.kksc.instaclone.handler.ex.CustomApiException;
import com.kksc.instaclone.repository.CommentRepository;
import com.kksc.instaclone.repository.PostRepository;
import com.kksc.instaclone.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public Comment addComment (String text, long postId, long sessionId) {
        Post post = postRepository.findById(postId).get();
        User user = userRepository.findById(sessionId).orElseThrow(()->{
            return new CustomApiException("유저 아이디를 찾을 수 없습니다.");
        });
        Comment comment = Comment.builder()
                .text(text)
                .post(post)
                .user(user)
                .build();
        return commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }
}
