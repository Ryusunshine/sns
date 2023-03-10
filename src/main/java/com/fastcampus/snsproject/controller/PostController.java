package com.fastcampus.snsproject.controller;

import com.fastcampus.snsproject.controller.request.PostWriteRequest;
import com.fastcampus.snsproject.controller.response.Response;
import com.fastcampus.snsproject.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public Response<Void> create(@RequestBody PostWriteRequest request, Authentication authentication) {
        postService.create(authentication.getName(), request.getTitle(), request.getBody());
        return Response.success(null);
    }


}
