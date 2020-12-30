package com.winterguard.book.springboot.service.posts;

import com.winterguard.book.springboot.domain.posts.Posts;
import com.winterguard.book.springboot.domain.posts.PostsRepository;
import com.winterguard.book.springboot.web.dto.PostsResponseDto;
import com.winterguard.book.springboot.web.dto.PostsSaveRequestDto;
import com.winterguard.book.springboot.web.dto.PostsUpdateRequestDto;
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

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
