package com.kksc.instaclone.repository;

import com.kksc.instaclone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    List<User> findByIdIsNotNull();
}
