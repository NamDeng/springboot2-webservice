package com.nwh.springboot.web;


import com.nwh.springboot.service.posts.PostsService;
import com.nwh.springboot.web.dto.PostsResponseDto;
import com.nwh.springboot.web.dto.PostsSaveRequestDto;
import com.nwh.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @GetMapping
    public PostsResponseDto findById(@PathVariable Long id) {
        return postService.findById(id);
    }

}
