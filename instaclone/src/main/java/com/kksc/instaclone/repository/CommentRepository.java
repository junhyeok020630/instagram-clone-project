package com.kksc.instaclone.repository;

import com.kksc.instaclone.entity.Comment;
import com.kksc.instaclone.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    void deleteCommentsByPost(Post post);
}
