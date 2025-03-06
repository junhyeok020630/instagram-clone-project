package com.kksc.instaclone.config.auth;

import com.kksc.instaclone.entity.User;
import com.kksc.instaclone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    // 스프링 시큐리티 로그인 요청시 자동으로 실행
    // 성공적으로 리턴되면 자동으로 UserDetails 로 세션 생성
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);
        return new PrincipalDetails(user);
    }
}
