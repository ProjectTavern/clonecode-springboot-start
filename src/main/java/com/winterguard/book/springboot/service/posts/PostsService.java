package com.winterguard.book.springboot.service.posts;

import com.winterguard.book.springboot.domain.posts.PostsRepository;
import com.winterguard.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    /* spring autowired vs 생성자 주입: https://yaboong.github.io/spring/2019/08/29/why-field-injection-is-bad/ */
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
