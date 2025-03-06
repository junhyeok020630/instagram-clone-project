package com.kksc.instaclone.repository;

import com.kksc.instaclone.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT * FROM post WHERE user_id = :sessionId OR (SELECT to_user_id FROM FOLLOW WHERE from_user_id = :sessionId) ORDER BY id DESC", nativeQuery = true)
    Page<Post> mainStory(long sessionId, Pageable pageable);

    @Query(value = "SELECT * FROM post WHERE tag LIKE :tag OR tag LIKE CONCAT('%,',:tag,',%') OR tag LIKE CONCAT('%,',:tag) " + "OR tag LIKE CONCAT(:tag,',%') ORDER BY id DESC", nativeQuery = true)
    Page<Post> searchResult(String tag, Pageable pageable);
}
